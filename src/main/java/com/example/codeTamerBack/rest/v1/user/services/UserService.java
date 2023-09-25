package com.example.codeTamerBack.rest.v1.user.services;

import com.example.codeTamerBack.rest.v1.common.services.UploadService;
import com.example.codeTamerBack.rest.v1.user.models.User;
import com.example.codeTamerBack.rest.v1.user.repositories.UserRepository;
import com.example.codeTamerBack.rest.v1.user.requests.AvatarRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User setAvatarToUser(AvatarRequest data) throws Exception {
        User currentUser = userRepo.findById(data.getUserId()).get();

        currentUser.setAvatar(data.getAvatar());

        userRepo.save(currentUser);

        return currentUser;
    }
}
