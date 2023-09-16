package com.example.codeTamerBack.rest.v1.task.repositories;

import com.example.codeTamerBack.rest.v1.task.model.Task;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    @Query
    Task findByTaskId(String taskId);

    @Query
    List<Task> findByUserId(String userId);

    @NotNull Page<Task> findAll(@NotNull Pageable pageable);
}
