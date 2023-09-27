package com.example.codeTamerBack.rest.v1.user.controller;

import com.example.codeTamerBack.rest.v1.user.requests.ChangePasswordRequest;
import com.example.codeTamerBack.rest.v1.user.interfaces.UserRole;
import com.example.codeTamerBack.rest.v1.user.models.User;
import com.example.codeTamerBack.rest.v1.user.repositories.UserRepository;
import com.example.codeTamerBack.rest.v1.user.requests.AvatarRequest;
import com.example.codeTamerBack.rest.v1.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController  {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService userService;

    @PostMapping("/users/registration")
    public User addUser(@RequestBody User user) throws Exception {
        return userService.addUser(user);
    }

    @PostMapping("/users/auth")
    public User Auth(@RequestBody User user) throws Exception {
        return userService.Auth(user);
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
    public User changePassword(
            @RequestBody ChangePasswordRequest data,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) throws Exception {
        return userService.ChangePassword(data, token);
    }

    @PatchMapping("/users")
    public User UpdateUser(@RequestBody User user)
    {
        return userRepo.save(user);
    }

    @GetMapping("/users/profile")
    public User getProfileByUserToken(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        return userRepo.findByToken(token);
    }

    @GetMapping("/users/get-list")
    public List<User> getAllUser(
            @RequestParam(value = "page", required = false) Integer page
    ){
        return userService.getAllUsers(page);
    }
}
