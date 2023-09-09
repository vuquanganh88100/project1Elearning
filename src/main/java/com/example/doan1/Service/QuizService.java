package com.example.doan1.Service;

import com.example.doan1.dto.CategoryDto;
import com.example.doan1.dto.LectureDto;
import com.example.doan1.dto.QuizDto;
import com.example.doan1.entities.CategoryEntity;
import com.example.doan1.entities.LectureEntity;
import com.example.doan1.entities.QuizEntity;
import com.example.doan1.repository.CategoryRepository;
import com.example.doan1.repository.LectureRepository;
import com.example.doan1.repository.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public String save(QuizDto quizDto) throws IOException {
        QuizEntity quizEntity=new QuizEntity();

        // Set the lecture title and video URL
        quizEntity.setTestName(quizDto.getTestName());
        // Set the associated category (course)
        CategoryEntity category = categoryRepository.getById(quizDto.getCourseId());
        quizEntity.setCategory(category);

        quizRepository.save(quizEntity);

        return "Tạo bài giảng thành công";
    }
    public QuizDto getQuizDtoById(Integer quizId) {
        QuizEntity quizEntity = quizRepository.findById(quizId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        return convertToDto(quizEntity);
    }
    public List<QuizDto> getAllQuizDto() {
        List<QuizEntity> quizEntities = quizRepository.findAll();
        return convertToDtoList(quizEntities);
    }

    private List<QuizDto> convertToDtoList(List<QuizEntity> entityList) {
        return entityList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private QuizDto convertToDto(QuizEntity quizEntity) {
        QuizDto dto=new QuizDto();
        dto.setQuizId(quizEntity.getQuizId());
        dto.setTestName(quizEntity.getTestName());
        dto.setCourseId(quizEntity.getCategory().getCourseId());
        return dto;
    }

}
