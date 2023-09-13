package com.example.codeTamerBack.rest.v1.action.services;

import com.example.codeTamerBack.rest.v1.Interfaces.ActionStatus;
import com.example.codeTamerBack.rest.v1.action.models.Action;
import com.example.codeTamerBack.rest.v1.action.repositories.ActionRepository;
import com.example.codeTamerBack.rest.v1.action.responses.ActionResponse;
import com.example.codeTamerBack.rest.v1.task.model.Task;
import com.example.codeTamerBack.rest.v1.model.User;
import com.example.codeTamerBack.rest.v1.task.repositories.TaskRepository;
import com.example.codeTamerBack.rest.v1.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {

    @Autowired
    private  ActionRepository actionRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public ActionService(){}

    public Action answerOnAction(@NotNull ActionStatus status, @NotNull String actionId) throws Exception {
        Action userAction = actionRepository.findByActionId(actionId);

        if(userAction == null) throw new Exception("user not found");

        userAction.setStatus(status);

        return userAction;
    }

    public List<ActionResponse> getActionsList(String token) throws Exception {
        User user = userRepository.findByToken(token);
        List<Action> action = actionRepository.findByUserId(user.getUserId());
//        Optional<Task> task = taskRepository.findById(action.)

        if(user == null) throw new Exception("user not found");

        return action.stream().map(actionItem -> {
            Optional<Task> task = taskRepository.findById(actionItem.getTaskId());
            return new ActionResponse(actionItem, user, task.get());
        }).toList();
    }
}
