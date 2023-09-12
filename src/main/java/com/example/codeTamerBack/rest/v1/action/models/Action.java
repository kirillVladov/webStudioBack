package com.example.codeTamerBack.rest.v1.action.models;

import com.example.codeTamerBack.rest.v1.Interfaces.ActionStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

public class Action {
    @Id
    private String actionId;
    private String userId;
    private String taskId;
    @CreatedDate
    private String expirationDate;
    private ActionStatus status;

    public Action(
                  @NotNull @JsonProperty String userId,
                  @NotNull @JsonProperty  String taskId,
                  @NotNull @JsonProperty String expirationDate
    ) {
        super();
        this.userId = userId;
        this.taskId = taskId;
        this.expirationDate = expirationDate;
        this.status = ActionStatus.awaiting;
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

    public void setStatus(ActionStatus status) {
        this.status = status;
    }

    public ActionStatus getStatus() {
        return status;
    }

}
