package com.example.codeTamerBack.rest.v1.order;

import com.example.codeTamerBack.rest.v1.user.interfaces.UserRole;
import com.example.codeTamerBack.rest.v1.user.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Order {
    @Id
    private String orderId;
    private String userId;
    private UserRole userRole;
    private String name;
    private String description;
    private Float price;
    private String startAt;
    private String endAt;

    private UserRepository userRepository;

    @JsonCreator
    public Order(
            @JsonProperty("userId") String userId,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("price") Float price,
            @JsonProperty("startAt") String startAt,
            @JsonProperty("userRole") UserRole userRole,
            @JsonProperty("endAt") String endAt
    ) {
        super();
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.startAt = startAt;
        this.endAt = endAt;
        this.userRole = userRole;
    }

    public String getUserId() {return userId;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getOrderId() {return orderId;}
    public UserRole getUserRole() {return userRole;}
    public String getStartAt() {return startAt;}
    public String getEndAt() {return endAt;}

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public static class OrderRequest {
        public String userId;
        public String name;
        public String description;
        public Float price;
        public String startAt;
        public String endAt;
        public UserRole userRole;

        public String getUserId() {return userId;}

        public void setUserRole(UserRole userRole) {
            this.userRole = userRole;
        }
    }
}
