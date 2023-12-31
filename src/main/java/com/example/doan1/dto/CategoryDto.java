package com.example.doan1.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class CategoryDto {
    private Integer courseId;
    private String courseName;
    private String courseImage;
    private MultipartFile imageFile;

}
