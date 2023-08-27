package com.example.codeTamerBack.repository;

import com.example.codeTamerBack.Interfaces.UserRole;
import com.example.codeTamerBack.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    @Query
    List<Order> findByUserRole(UserRole userRole);
    @Query
    Order findByUserId(String userId);
}
