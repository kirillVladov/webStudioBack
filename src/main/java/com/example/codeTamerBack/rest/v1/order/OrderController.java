package com.example.codeTamerBack.rest.v1.order;

import com.example.codeTamerBack.rest.v1.user.interfaces.UserRole;
import com.example.codeTamerBack.rest.v1.user.models.User;
import com.example.codeTamerBack.rest.v1.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
