package com.example.codeTamerBack.rest.v1.call;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CallRepository extends MongoRepository<Call, String> {
}
