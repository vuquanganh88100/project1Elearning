package com.example.doan1.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
@Data
@Entity
@Table(name="courses",schema = "doan1",catalog = "")
public class CategoryEntity {
    private int courseId;
    private String courseName;
    private String courseImage;
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    @Basic
    @Column(name = "course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    @Basic
    @Column(name = "course_image")
    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryEntity that)) return false;
        return getCourseId() == that.getCourseId() && Objects.equals(getCourseName(), that.getCourseName()) && Objects.equals(getCourseImage(), that.getCourseImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId(), getCourseName(), getCourseImage());
    }
}