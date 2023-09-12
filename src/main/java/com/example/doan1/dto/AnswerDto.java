package com.example.doan1.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnswerDto {
    private Integer ansId;
    private Integer userId;
    private Integer quizId;
    private Double score;
    private List<String> selectedAns;
    private  List<String>correctAns;
    private List<Boolean> answerResults; // Add this field to store answer results

}
