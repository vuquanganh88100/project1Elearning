package com.example.doan1.repository;

import com.example.doan1.entities.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<LectureEntity,Integer> {
    List<LectureEntity> findByCategory_CourseId(Integer courseId);

}
