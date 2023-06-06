package com.example.codeTamerBack.repository;

import com.example.codeTamerBack.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {
    @Query(fields = "{'email' : 1, 'password': 1}")
    User findByEmail(String email);
}
