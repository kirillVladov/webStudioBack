package com.example.codeTamerBack.rest.v1.task.responses;

import com.example.codeTamerBack.rest.v1.Interfaces.Currency;
import com.example.codeTamerBack.rest.v1.Interfaces.TaskPriority;
import com.example.codeTamerBack.rest.v1.model.User;
import com.example.codeTamerBack.rest.v1.task.model.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskResponse {
    public String taskId;
    public User user;
    public String header;
    public TaskPriority priority;
    public List<String> tags;
    public String description;
    public int price;
    public Currency currency;
    public String startAt;
    public String expiresAt;

    public TaskResponse(
            Task task,
            User user
    ) {
        this.taskId = task.getTaskId();
        this.user = user;
        this.header = task.getHeader();
        this.priority = task.getPriority();
        this.tags = task.getTags();
        this.description = task.getDescription();
        this.price = task.getPrice();
        this.currency = task.getCurrency();
        this.startAt = task.getStartAt();
        this.expiresAt = task.getExpiresAt();
    }
}
