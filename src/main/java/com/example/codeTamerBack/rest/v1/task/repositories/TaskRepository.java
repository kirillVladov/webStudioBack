package com.example.codeTamerBack.rest.v1.task.repositories;

import com.example.codeTamerBack.rest.v1.model.User;
import com.example.codeTamerBack.rest.v1.task.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    @Query
    Task findByTaskId(String taskId);

    @Query
    List<Task> findByUserId(String userId);

    @Query(value = "{}", fields = "{messages: {$slice: [?0, ?1]}}")
    List<Task> findTasks(int skip, int limit);
}
