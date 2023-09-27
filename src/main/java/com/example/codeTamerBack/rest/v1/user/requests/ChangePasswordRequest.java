package com.example.codeTamerBack.rest.v1.user.requests;

public class ChangePasswordRequest {
    public String oldPassword;
    public String password;

    public ChangePasswordRequest(
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
