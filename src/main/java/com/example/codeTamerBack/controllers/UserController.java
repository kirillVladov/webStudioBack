package com.example.codeTamerBack.controllers;

import com.example.codeTamerBack.Interfaces.UserRole;
import com.example.codeTamerBack.model.User;
import com.example.codeTamerBack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @PostMapping("/users/registration")
    public User addUser(@RequestBody User user) {

        int strength = 10; // work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.password = encodedPassword;
        return userRepo.save(user);
    }

    @PostMapping("/users/auth")
    public Boolean Auth(@RequestBody User user) throws UnsupportedEncodingException {
        User userModel = userRepo.findByEmail(user.getEmail());

        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder();

        if(userModel == null) return false;

        return bCryptPasswordEncoder.matches(user.getPassword(), userModel.getPassword());
    }

    @GetMapping("/users")
    public List<User> getUserByType(@RequestParam("userRole") UserRole userRole) {
        return userRepo.findByRole(userRole);
    }

//    @GetMapping("/users/profile")
//    public List<User> getProfileByUserToken(@RequestHeader("token") String token) {
//        return userRepo.findByRole(userRole);
//    }

    @GetMapping("/users/getAllUser")
    public List<User> getAllUser(){
        return userRepo.findAll();
    }
}
