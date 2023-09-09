package com.example.doan1.repository;

import com.example.doan1.entities.ExamEntity;
import com.example.doan1.entities.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamRepository extends JpaRepository<ExamEntity,Integer> {
    @Query("SELECT e FROM ExamEntity e WHERE e.quizEntity.quizId = :quizId")
    List<ExamEntity> findByQuizId(@Param("quizId") Integer quizId);
    @Query("SELECT COUNT(e) FROM ExamEntity e WHERE e.quizEntity.quizId = :quizId")
    Integer countExamsByQuizId(@Param("quizId") Integer quizId);
}
