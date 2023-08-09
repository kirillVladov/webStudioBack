package com.example.codeTamerBack.controllers;

import com.example.codeTamerBack.Interfaces.ProjectType;
import com.example.codeTamerBack.model.Project;
import com.example.codeTamerBack.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectRepository repository;

    @PostMapping("/projects")
    public Project addProject(@RequestBody Project project) {
        return repository.save(project);
    }

    @GetMapping("/projects")
    public List<Project> getProjectsList(@RequestParam(value = "null", required = false) ProjectType type) {
        if(type == null) {
            return repository.findAll();
        }

        return repository.findAllByType(type);
    }
}
