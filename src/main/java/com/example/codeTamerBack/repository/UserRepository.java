package com.example.codeTamerBack.repository;

import com.example.codeTamerBack.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
