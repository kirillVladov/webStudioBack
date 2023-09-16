package com.example.codeTamerBack.rest.v1.task.services;

import com.example.codeTamerBack.rest.v1.common.responses.SuccessResponse;
import com.example.codeTamerBack.rest.v1.user.models.User;
import com.example.codeTamerBack.rest.v1.user.repositories.UserRepository;
import com.example.codeTamerBack.rest.v1.task.model.Task;
import com.example.codeTamerBack.rest.v1.task.repositories.TaskRepository;
import com.example.codeTamerBack.rest.v1.task.responses.TaskResponse;
import com.example.codeTamerBack.rest.v1.task.responses.TasksWithPaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksServices {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public TasksServices(){}

    public TaskResponse addTask(Task task, String token) throws Exception {
        User currentUser = userRepository.findByToken(token);

        if(currentUser == null) throw new Exception("user not found");

        task.setUser(currentUser.getUserId());
        taskRepository.save(task);

        return new TaskResponse(task, currentUser);
    }

    public TaskResponse getTaskById(String taskId) throws Exception {
        Task task = taskRepository.findByTaskId(taskId);

        if(task == null) throw new Exception("task not found");

        Optional<User> user = userRepository.findById(task.getUserId());

        if(user.isEmpty()) throw new Exception("user not found");

        return new TaskResponse(task, user.get());
    }

    public SuccessResponse deleteTask(String taskId) throws Exception {
        Task currentTask = taskRepository.findByTaskId(taskId);

        if(currentTask == null) throw new Exception("task not found");

        taskRepository.deleteById(taskId);

        return new SuccessResponse();
    }

    public List<TaskResponse> getTaskByUser(String token) throws Exception {
        User user = userRepository.findByToken(token);

        if(user == null) throw new Exception("user not found");

        return taskRepository.findByUserId(user.getUserId()).stream().map(item -> new TaskResponse(item, user)).toList();
    }

    public TasksWithPaginationResponse getTasksList(int page, int perPage) {
        Page<Task> tasks = taskRepository.findAll(PageRequest.of(page - 1, perPage));
        int countPages = tasks.getTotalPages();
        int totalItemsCount = countPages * perPage;

        List<TaskResponse> tasksList = tasks.stream().map(item -> {
            User user = userRepository.findById(item.getUserId()).get();

            return new TaskResponse(item, user);
        }).toList();

        return new TasksWithPaginationResponse(tasksList, countPages, page, totalItemsCount);
    }
}
