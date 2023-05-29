package com.example.codeTamerBack.repository;

import com.example.codeTamerBack.model.Call;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CallRepository extends MongoRepository<Call, String> {
}
