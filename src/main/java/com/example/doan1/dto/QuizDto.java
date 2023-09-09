package com.example.doan1.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class QuizDto {
    private  Integer quizId;
    private String testName;
    private Integer courseId;
}
