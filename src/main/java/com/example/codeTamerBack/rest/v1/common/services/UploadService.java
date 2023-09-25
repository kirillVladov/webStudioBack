package com.example.codeTamerBack.rest.v1.common.services;

import com.example.codeTamerBack.rest.v1.common.interfaces.FileTypes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UploadService {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/public/images";
    public static String[] allowedFileTypes = {FileTypes.jpeg.getType(), FileTypes.jpeg.getType()};

    public static String uploadImage(MultipartFile file) throws Exception {
        String uuid = UUID.randomUUID().toString();
        String path = UPLOAD_DIRECTORY + "/" + uuid + ".png";

        if(file.getContentType() == null) throw new Exception("FILE IS EMPTY");

        if(Arrays.asList(allowedFileTypes).contains(file.getContentType())) throw new Exception("FILE TYPE NOT ALLOWED");

        try {
            Path pathDirectory = Paths.get(UPLOAD_DIRECTORY);
            Files.createDirectories(pathDirectory);
            Files.write(Path.of(path), file.getBytes());
        } catch (Exception e) {
            log.info(e.toString());
        }

        return path;
    }
}
