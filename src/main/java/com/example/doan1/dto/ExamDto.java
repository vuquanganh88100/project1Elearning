package com.example.doan1.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExamDto {
    private Integer examId;
    private Integer quizId;
    private Integer quesNum;
    private String content;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAns;

}
