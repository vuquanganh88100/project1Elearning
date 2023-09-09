package com.example.doan1.repository;

import com.example.doan1.entities.LectureEntity;
import com.example.doan1.entities.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<QuizEntity,Integer> {
    List<QuizEntity> findByCategory_CourseId(Integer courseId);

}
