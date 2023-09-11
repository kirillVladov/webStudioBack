package com.example.codeTamerBack.rest.v1.repository;

import com.example.codeTamerBack.rest.v1.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TaskRepository extends MongoRepository<Task, String> {
    @Query
    Task findByTaskId(String taskId);
}
