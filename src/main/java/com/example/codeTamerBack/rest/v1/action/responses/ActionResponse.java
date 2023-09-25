package com.example.codeTamerBack.rest.v1.action.responses;

import com.example.codeTamerBack.rest.v1.Interfaces.ActionStatus;
import com.example.codeTamerBack.rest.v1.action.models.Action;
import com.example.codeTamerBack.rest.v1.task.model.Task;
import com.example.codeTamerBack.rest.v1.user.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionResponse {
    private String actionId;
    private String taskId;
    private String expirationDate;
    private ActionStatus status;
    private User user;
    private String name;
    private String description;
//    private Task task;

    public ActionResponse() {}

    public ActionResponse(Action action, User user, Task task) {
        this.actionId = action.getActionId();
        this.taskId = action.getTaskId();
        this.status = action.getStatus();
        this.expirationDate = action.getExpirationDate();
        this.user = user;
        this.name = task.getHeader();
        this.description = task.getDescription();
    }
}
