package com.example.codeTamerBack.requests;

import com.example.codeTamerBack.Interfaces.UserRole;
import com.example.codeTamerBack.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

public class OrderRequest {
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
