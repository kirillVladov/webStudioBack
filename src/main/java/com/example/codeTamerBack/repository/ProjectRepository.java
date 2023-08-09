package com.example.codeTamerBack.repository;

import com.example.codeTamerBack.Interfaces.ProjectType;
import com.example.codeTamerBack.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {
    @Query
    List<Project> findAllByType(ProjectType type);
}
