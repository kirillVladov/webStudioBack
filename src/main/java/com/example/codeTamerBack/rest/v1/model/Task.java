package com.example.codeTamerBack.rest.v1.model;

import com.example.codeTamerBack.rest.v1.Interfaces.Currency;
import com.example.codeTamerBack.rest.v1.Interfaces.TaskPriority;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Task {
    @Id
    public String taskId;
    public User user;
    public String header;
    public TaskPriority priority;
    public String tags;
    public String description;
    public int price;
    public Currency currency;
    public String startAt;
    public String expiresAt;

    public Task(
            @JsonProperty("taskId") String taskId,
            @JsonProperty("user") User user,
            @JsonProperty("priority") TaskPriority priority,
            @JsonProperty("header") String header,
            @JsonProperty("tags") String tags,
            @JsonProperty("description") String description,
            @JsonProperty("price") int price,
            @JsonProperty("currency") Currency currency,
            @JsonProperty("startAt") String startAt,
            @JsonProperty("expiresAt") String expiresAt
    ) {
        this.taskId = taskId;
        this.priority = priority;
        this.user = user;
        this.header = header;
        this.tags = tags;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.startAt = startAt;
        this.expiresAt = expiresAt;
    }

//    public Task(Task task) {
//        this.taskId = task.getTaskId();
//        this.priority = task.getPriority();
//        this.user = task.getUser();
//        this.header = task.getHeader();
//        this.tags = task.getTags();
//        this.description = task.getDescription();
//        this.price = task.getPrice();
//        this.currency = task.getCurrency();
//        this.startAt = task.getStartAt();
//        this.expiresAt = task.getExpiresAt();
//    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTaskId() {
        return taskId;
    }
    public TaskPriority getPriority() {
        return priority;
    }

    public User getUser() {
        return user;
    }

    public String getHeader() {
        return header;
    }

    public String getTags() {
        return tags;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getStartAt() {
        return startAt;
    }

    public String getExpiresAt() {
        return expiresAt;
    }
}
