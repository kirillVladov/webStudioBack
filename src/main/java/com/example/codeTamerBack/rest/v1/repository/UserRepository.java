package com.example.codeTamerBack.rest.v1.repository;

import com.example.codeTamerBack.rest.v1.Interfaces.UserRole;
import com.example.codeTamerBack.rest.v1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Query
    User findByEmail(String email);
    @Query
    User findByToken(String token);
    @Query(fields = "{'userId': 1, 'email' : 1, 'name': 1, 'surname': 1, 'role': 1, 'phoneNumber': 1, 'avatar': 1}")
    List<User> findByRole(UserRole userRole);

    @Query(value = "{}", fields = "{messages: {$slice: [?0, ?1]}}")
    List<User> findUsers(int skip, int limit);

//    @Query(fields = "{'email' : 1, 'name': 1, 'surname': 1, 'role': 1, 'phoneNumber': 1}")
//    List<User> findByToken(UserRole userRole);
}
