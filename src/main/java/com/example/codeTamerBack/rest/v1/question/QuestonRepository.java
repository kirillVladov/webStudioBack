package com.example.codeTamerBack.rest.v1.question;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestonRepository extends MongoRepository<Question, String> {
}
