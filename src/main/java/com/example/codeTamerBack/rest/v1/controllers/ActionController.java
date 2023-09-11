package com.example.codeTamerBack.rest.v1.controllers;

import com.example.codeTamerBack.rest.v1.model.Action;
import com.example.codeTamerBack.rest.v1.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActionController {
    @Autowired
    private ActionRepository actionRepository;

    @PostMapping("action")
    public Action addAction(@RequestBody Action data) {
        return actionRepository.save(data);
    }

    @GetMapping("action/user")
    public List<Action> getActions(@RequestBody Action data) {
        return actionRepository.findAll();
    }
}
