package com.example.codeTamerBack.rest.v1.action.repositories;

import com.example.codeTamerBack.rest.v1.action.models.Action;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ActionRepository extends MongoRepository<Action, String> {
    @Query
    public List<Action> findByUserId(String userId);

    @Query
    public Action findByActionId(String id);
}
