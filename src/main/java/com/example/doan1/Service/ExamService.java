package com.example.doan1.Service;

import com.example.doan1.dto.CategoryDto;
import com.example.doan1.dto.ExamDto;
import com.example.doan1.dto.QuizDto;
import com.example.doan1.entities.CategoryEntity;
import com.example.doan1.entities.ExamEntity;
import com.example.doan1.entities.QuizEntity;
import com.example.doan1.repository.ExamRepository;
import com.example.doan1.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ExamService {
@Autowired
ExamRepository examRepository;
    @Autowired
    QuizRepository quizRepository;


    public String save(ExamDto examDto) throws IOException{
        ExamEntity examEntity=new ExamEntity();
        examEntity.setContent(examDto.getContent());
        examEntity.setCorrectAns(examDto.getCorrectAns());
        QuizEntity quizEntity=quizRepository.getById(examDto.getQuizId());
        examEntity.setQuizEntity(quizEntity);
        examEntity.setOption1(examDto.getOption1());
        examEntity.setOption2(examDto.getOption2());
        examEntity.setOption3(examDto.getOption3());
        examEntity.setOption4(examDto.getOption4());
        examEntity.setQuesNum(examDto.getQuesNum());
        examRepository.save(examEntity);
        return "tao moi thanh cong" ;
    }
    public List<ExamDto> getALLExamDtos() {
        List<ExamEntity> examEntities = examRepository.findAll();
        return convertToDtoList(examEntities);
    }

    private List<ExamDto> convertToDtoList(List<ExamEntity> entityList) {
        return entityList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ExamDto convertToDto(ExamEntity examEntity) {
        ExamDto examDto=new ExamDto();
        examDto.setExamId(examEntity.getExamId());
        examDto.setQuizId(examEntity.getQuizEntity().getQuizId());
        examDto.setContent(examEntity.getContent());
        examDto.setOption2(examEntity.getOption2());
        examDto.setOption3(examEntity.getOption3());
        examDto.setOption4(examEntity.getOption4());
        examDto.setOption1(examEntity.getOption1());
        examDto.setCorrectAns(examEntity.getCorrectAns());
        return  examDto;
    }

}
