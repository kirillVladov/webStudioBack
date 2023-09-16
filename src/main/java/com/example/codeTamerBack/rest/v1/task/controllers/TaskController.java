package com.example.codeTamerBack.rest.v1.task.controllers;

import com.example.codeTamerBack.rest.v1.common.responses.SuccessResponse;
import com.example.codeTamerBack.rest.v1.task.model.Task;
import com.example.codeTamerBack.rest.v1.task.repositories.TaskRepository;
import com.example.codeTamerBack.rest.v1.user.repositories.UserRepository;
import com.example.codeTamerBack.rest.v1.task.responses.TaskResponse;
import com.example.codeTamerBack.rest.v1.task.responses.TasksWithPaginationResponse;
import com.example.codeTamerBack.rest.v1.task.services.TasksServices;
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
    @Autowired
    private TasksServices tasksServices;

    @PostMapping("/task")
    public TaskResponse addTask(
            @RequestBody Task task,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) throws Exception {
        return tasksServices.addTask(task, token);
    }
    @GetMapping("/task/{id}")
    public TaskResponse getTaskById(@PathVariable("id") String id) throws Exception {
        return tasksServices.getTaskById(id);
    }

    @DeleteMapping("/task/{id}")
    public SuccessResponse deleteTask(@PathVariable("id")String taskId) throws Exception {
        return tasksServices.deleteTask(taskId);
    }


    //@TODO check needest
//    @PatchMapping("/task")
//    public Task getTaskById(@RequestBody Task task) {
//        return taskRepository.save(task);
//    }

    @GetMapping("/task/user")
    public List<TaskResponse> getTasksByUser(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) throws Exception {
        return tasksServices.getTaskByUser(token);
    }

    @GetMapping("/tasks")
    public TasksWithPaginationResponse getTasksList(
            @RequestParam("page") int page
    ) {
        int perPage = 10;
        return tasksServices.getTasksList(page, perPage);
    }
}
