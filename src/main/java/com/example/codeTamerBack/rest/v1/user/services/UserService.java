package com.example.codeTamerBack.rest.v1.user.services;

import com.example.codeTamerBack.rest.v1.user.requests.ChangePasswordRequest;
import com.example.codeTamerBack.rest.v1.user.models.User;
import com.example.codeTamerBack.rest.v1.user.repositories.UserRepository;
import com.example.codeTamerBack.rest.v1.user.requests.AvatarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    private int encodeLength = 12;

    public User setAvatarToUser(AvatarRequest data) throws Exception {
        User currentUser = userRepo.findById(data.getUserId()).get();
        currentUser.setAvatar(data.getAvatar());
        userRepo.save(currentUser);

        return currentUser;
    }

    public User addUser(User user) throws Exception {
        if(userRepo.findByEmail(user.getEmail()) != null) throw new Exception("email busy");

        String encodedPassword = encryptPassword(user.getPassword());
        String token = generateToken(user.getUserId());
        user.setToken(token);
        user.password = encodedPassword;

        return userRepo.save(user);
    }

    public User Auth(User user) throws Exception {
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

    public User ChangePassword(ChangePasswordRequest data, String token) throws Exception {
        User currentUser = userRepo.findByToken(token);

        if(Objects.equals(data.getOldPassword(), data.getPassword()))
            throw new Exception("password not corrected");

        currentUser.setPassword(data.getPassword());

        return userRepo.save(currentUser);
    }

    public List<User> getAllUsers(
            Integer page
    ) {
        int perPage = 10;

        if(page == null) return userRepo.findAll();

        return userRepo.findUsers((page - 1) * perPage, perPage);
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder =
                new BCryptPasswordEncoder(encodeLength, new SecureRandom());

        return passwordEncoder.encode(password);
    }

    private String generateToken(String userId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        BCryptPasswordEncoder passwordEncoder =
                new BCryptPasswordEncoder(encodeLength, new SecureRandom());

        return passwordEncoder.encode(timestamp + "-" + userId);
    }
}
