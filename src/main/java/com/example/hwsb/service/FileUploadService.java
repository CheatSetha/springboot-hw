package com.example.hwsb.service;


import com.example.hwsb.model.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    FileUpload uploadSingle(MultipartFile file);
}
