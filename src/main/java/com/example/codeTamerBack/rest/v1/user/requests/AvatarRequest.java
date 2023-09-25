package com.example.codeTamerBack.rest.v1.user.requests;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class AvatarRequest {
    private String avatar;
    private String userId;

    public String getAvatar() {
        return avatar;
    }

    public String getUserId() {
        return userId;
    }
}
