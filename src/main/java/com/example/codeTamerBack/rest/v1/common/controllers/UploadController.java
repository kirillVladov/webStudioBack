package com.example.codeTamerBack.rest.v1.common.controllers;

import com.example.codeTamerBack.rest.v1.common.services.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload-file")
    public String uploadImage(
            @RequestParam("image") MultipartFile file
    ) throws Exception {
      return UploadService.uploadImage(file);
    }
}
