package com.example.doan1.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name="lectures",schema = "doan1",catalog = "")
public class LectureEntity {
    @Id
    @Column(name="lecture_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lectureId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_Id", referencedColumnName = "course_id")
    private CategoryEntity category;
    @Column(name="lecture_Title")

    private String lectureTitle;
    @Column(name="video_Url")

    private String videoUrl;

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getLectureTitle() {
        return lectureTitle;
    }

    public void setLectureTitle(String lectureTitle) {
        this.lectureTitle = lectureTitle;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LectureEntity that)) return false;
        return getLectureId() == that.getLectureId() && getCategory().equals(that.getCategory()) && getLectureTitle().equals(that.getLectureTitle()) && getVideoUrl().equals(that.getVideoUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLectureId(), getCategory(), getLectureTitle(), getVideoUrl());
    }
}
