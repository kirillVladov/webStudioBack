package com.example.codeTamerBack.rest.v1.requests;

import com.example.codeTamerBack.rest.v1.Interfaces.UserRole;

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
