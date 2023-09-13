package com.example.codeTamerBack.rest.v1.task.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TasksWithPaginationResponse {
    private List<TaskResponse> data;
    private int lastPage;
    private int currentPage;
    public TasksWithPaginationResponse (
            List<TaskResponse> data,
            int lastPage,
            int currentPage
    ) {
        this.data = data;
        this.lastPage = lastPage;
        this.currentPage = currentPage;
    }
}
