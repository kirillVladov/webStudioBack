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
    private int totalItems;
    public TasksWithPaginationResponse (
            List<TaskResponse> data,
            int lastPage,
            int currentPage,
            int totalItems
    ) {
        this.data = data;
        this.totalItems = totalItems;
        this.lastPage = lastPage;
        this.currentPage = currentPage;
    }
}
