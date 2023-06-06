package com.example.codeTamerBack.controllers;

import com.example.codeTamerBack.model.Call;
import com.example.codeTamerBack.repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CallController {
    @Autowired
    private CallRepository callRepo;

    @PostMapping("/calls/add")
    public Call addCall(@RequestBody Call call) {
        return callRepo.save(call);
    }

    @GetMapping("/calls/getList")
    public List<Call> getCallList() {
        return callRepo.findAll();
    }
}
