package com.example.codeTamerBack.controllers;

import com.example.codeTamerBack.model.User;
import com.example.codeTamerBack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/users")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userRepo.findAll();
    }
}
