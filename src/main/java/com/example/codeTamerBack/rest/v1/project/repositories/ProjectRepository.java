package com.example.codeTamerBack.rest.v1.project.repositories;

import com.example.codeTamerBack.rest.v1.Interfaces.ProjectType;
import com.example.codeTamerBack.rest.v1.project.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {
    @Query
    List<Project> findAllByType(ProjectType type);
}
