package com.example.codeTamerBack.rest.v1.repository;

import com.example.codeTamerBack.rest.v1.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestonRepository extends MongoRepository<Question, String> {
}
