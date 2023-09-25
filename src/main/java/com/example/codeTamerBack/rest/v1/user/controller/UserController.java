package com.example.codeTamerBack.rest.v1.user.controller;

import com.example.codeTamerBack.rest.v1.Interfaces.ChangePasswordResponse;
import com.example.codeTamerBack.rest.v1.Interfaces.UserRole;
import com.example.codeTamerBack.rest.v1.common.services.UploadService;
import com.example.codeTamerBack.rest.v1.user.models.User;
import com.example.codeTamerBack.rest.v1.user.repositories.UserRepository;
import com.example.codeTamerBack.rest.v1.user.requests.AvatarRequest;
import com.example.codeTamerBack.rest.v1.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController  {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService userService;
    private int encodeLength = 12;

    @PostMapping("/users/registration")
    public User addUser(@RequestBody User user) throws Exception {
        if(userRepo.findByEmail(user.getEmail()) != null) throw new Exception("email busy");

        String encodedPassword = encryptPassword(user.getPassword());
        String token = generateToken(user.getUserId());

        user.setToken(token);
        user.password = encodedPassword;
        return userRepo.save(user);
    }

    @PostMapping("/users/auth")
    public User Auth(@RequestBody User user) throws Exception {
        User userModel = userRepo.findByEmail(user.getEmail());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(encodeLength, new SecureRandom());

        if(userModel == null) throw new Exception("non");

        Boolean isChecked = passwordEncoder.matches(user.getPassword(), userModel.getPassword());

        String token = generateToken(user.getUserId());

        if(isChecked) {
            userModel.setToken(token);
            userRepo.save(userModel);
        }

        return userModel;
    }

    @PostMapping("users/avatar")
    public User setAvatar(@RequestBody AvatarRequest data) throws Exception {
        return userService.setAvatarToUser(data);
    }

    @GetMapping("/users")
    public List<User> getUserByType(@RequestParam("userRole") UserRole userRole) {
        return userRepo.findByRole(userRole);
    }

    @PatchMapping("/users/change-password")
    public User changePassword(@RequestBody ChangePasswordResponse data, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) throws Exception {
        User currentUser = userRepo.findByToken(token);

        if(Objects.equals(data.getOldPassword(), data.getPassword())) throw new Exception("password not corrected");

        currentUser.setPassword(data.getPassword());

        return userRepo.save(currentUser);
    }

    @PatchMapping("/users")
    public User UpdateUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @GetMapping("/users/profile")
    public User getProfileByUserToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return userRepo.findByToken(token);
    }

    @GetMapping("/users/get-list")
    public List<User> getAllUser(@RequestParam(value = "page", required = false) Integer page){
        int perPage = 10;
        if(page == null) return userRepo.findAll();

        return userRepo.findUsers((page - 1) * perPage, perPage);
    }

    private String generateToken(String userId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        BCryptPasswordEncoder passwordEncoder =
                new BCryptPasswordEncoder(encodeLength, new SecureRandom());

        return passwordEncoder.encode(timestamp + "-" + userId);
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder =
                new BCryptPasswordEncoder(encodeLength, new SecureRandom());

        return passwordEncoder.encode(password);
    }
}
