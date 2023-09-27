package com.example.codeTamerBack.rest.v1.feedback.controller;

import com.example.codeTamerBack.rest.v1.feedback.repository.QuestonRepository;
import com.example.codeTamerBack.rest.v1.feedback.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    @Autowired
    private QuestonRepository repository;

    @PostMapping("/callback/question")
    public Question addQuestion(@RequestBody Question question) {
        return repository.save(question);
    }
}
