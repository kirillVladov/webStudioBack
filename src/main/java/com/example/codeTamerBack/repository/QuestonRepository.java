package com.example.codeTamerBack.repository;

import com.example.codeTamerBack.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestonRepository extends MongoRepository<Question, String> {
}
