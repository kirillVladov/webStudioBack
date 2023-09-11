package com.example.codeTamerBack.rest.v1.repository;

import com.example.codeTamerBack.rest.v1.model.Call;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CallRepository extends MongoRepository<Call, String> {
}
