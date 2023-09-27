package com.example.codeTamerBack.rest.v1.action.requests;

import com.example.codeTamerBack.rest.v1.action.interfaces.ActionStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public class ActionResponseRequest {
    private ActionStatus status;
    private String actionId;

    @JsonCreator
    public ActionResponseRequest(
            @NotNull @JsonProperty ActionStatus status,
            @NotNull @JsonProperty String actionId
    ) {
        this.status = status;
        this.actionId = actionId;
    }

    public ActionStatus getStatus() {
        return status;
    }


    public String getActionId() {
        return actionId;
    }
}
