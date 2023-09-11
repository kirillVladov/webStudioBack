package com.example.codeTamerBack.rest.v1.repository;

import com.example.codeTamerBack.rest.v1.model.Action;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionRepository extends MongoRepository<Action, String> {
}
