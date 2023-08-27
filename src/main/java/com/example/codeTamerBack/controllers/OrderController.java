package com.example.codeTamerBack.controllers;

import com.example.codeTamerBack.Interfaces.UserRole;
import com.example.codeTamerBack.model.Order;
import com.example.codeTamerBack.model.User;
import com.example.codeTamerBack.repository.OrderRepository;
import com.example.codeTamerBack.repository.UserRepository;
import com.example.codeTamerBack.requests.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/order")
    public Order addOrder(@RequestBody Order order) {
        Optional<User> currentUser = userRepository.findById(order.getUserId());
        order.setUserRole(currentUser.get().getRole());
        return orderRepository.save(order);
    }

    @GetMapping("/order")
    public List<Order> getOrder(@RequestParam("userRole") UserRole userRole) {
        return orderRepository.findByUserRole(userRole);
    }
}
