package com.example.codeTamerBack.rest.v1.model;

import com.example.codeTamerBack.rest.v1.Interfaces.ActionStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

public class Action {
    @Id
    private String actionId;
    private String userId;
    private String taskId;
    @CreatedDate
    private String expirationDate;
    private String name;
    private String description;
    private ActionStatus status;

    public Action(@JsonProperty String actionId,
                  @JsonProperty String userId,
                  @JsonProperty  String taskId,
                  @JsonProperty String expirationDate,
                  @JsonProperty String name,
                  @JsonProperty String description,
                  @JsonProperty ActionStatus status
    ) {
        this.actionId = actionId;
        this.userId = userId;
        this.taskId = taskId;
        this.expirationDate = expirationDate;
        this.name = name;
        this.description = description;
        this.status = status;
    }
    public String getActionId() {
        return actionId;
    }

    public String getUserId() {
        return userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ActionStatus getStatus() {
        return status;
    }

}
