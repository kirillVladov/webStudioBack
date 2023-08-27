package com.example.codeTamerBack.repository;

import com.example.codeTamerBack.Interfaces.UserRole;
import com.example.codeTamerBack.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Query(fields = "{'email' : 1, 'password': 1}")
    User findByEmail(String email);
    @Query(fields = "{'email' : 1, 'name': 1, 'surname': 1, 'role': 1, 'phoneNumber': 1, 'token': 1}")
    List<User> findByRole(UserRole userRole);

    @Query(fields = "{'email' : 1, 'name': 1, 'surname': 1, 'role': 1, 'phoneNumber': 1, 'token': 1}")
    List<User> findByToken(UserRole userRole);
}
