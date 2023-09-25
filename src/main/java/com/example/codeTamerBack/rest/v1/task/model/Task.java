package com.example.codeTamerBack.rest.v1.task.model;

import com.example.codeTamerBack.rest.v1.Interfaces.Currency;
import com.example.codeTamerBack.rest.v1.Interfaces.TaskPriority;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Task {
    @Id
    public String taskId;
    public String userId;
    public String header;
    public TaskPriority priority;
    public List<String> tags;
    public String description;
    public int price;
    public Currency currency;
    public String startAt;
    public String expiresAt;

    public Task(
            @JsonProperty("priority") TaskPriority priority,
            @JsonProperty("header") String header,
            @JsonProperty("tags") List<String> tags,
            @JsonProperty("description") String description,
            @JsonProperty("price") int price,
            @JsonProperty("currency") Currency currency,
            @JsonProperty("startAt") String startAt,
            @JsonProperty("expiresAt") String expiresAt
    ) {
        super();
        this.priority = priority;
        this.header = header;
        this.tags = tags;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.startAt = startAt;
        this.expiresAt = expiresAt;
    }

    public void setUser(String userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }
    public TaskPriority getPriority() {
        return priority;
    }

    public String getUserId() {
        return userId;
    }

    public String getHeader() {
        return header;
    }

    public List<String> getTags() {
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
