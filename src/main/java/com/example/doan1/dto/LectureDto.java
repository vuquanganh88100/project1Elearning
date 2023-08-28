package com.example.doan1.dto;

import lombok.Data;

@Data
public class LectureDto {
    private Integer lectureId;
    private Integer courseId;
    private String lectureTitle;
    private String videoUrl;
}
