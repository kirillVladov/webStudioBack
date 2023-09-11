package com.example.codeTamerBack.rest.v1.controllers;

import com.example.codeTamerBack.rest.v1.model.Task;
import com.example.codeTamerBack.rest.v1.model.User;
import com.example.codeTamerBack.rest.v1.repository.TaskRepository;
import com.example.codeTamerBack.rest.v1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        User currentUser = userRepository.findByToken(token);
        task.setUser(currentUser);
        return taskRepository.save(task);
    }

//    @GetMapping("/task")
//    public Task getTaskById(@RequestParam("id") String id) {
//        return taskRepository.findByTaskId(id);
//    }

    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable("id") String id) {
        return taskRepository.findByTaskId(id);
    }

    @PatchMapping("/task")
    public Task getTaskById(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public List<Task> getTasksList() {
        return taskRepository.findAll();
    }
}
