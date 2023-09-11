package com.example.codeTamerBack.rest.v1.Interfaces;

public class ChangePasswordResponse {
    public String oldPassword;
    public String password;

    public ChangePasswordResponse(
            String password,
            String oldPassword
    ) {
        this.password = password;
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getOldPassword() {
        return oldPassword;
    }
}
