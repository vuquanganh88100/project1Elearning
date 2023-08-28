package com.example.doan1.Service;

import com.example.doan1.dto.LectureDto;
import com.example.doan1.entities.CategoryEntity;
import com.example.doan1.entities.LectureEntity;
import com.example.doan1.repository.CategoryRepository;
import com.example.doan1.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureService {
    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    CategoryRepository categoryRepository;
    public List<LectureDto> getLecturesByCourseId(Integer courseId) {
        List<LectureEntity> lectureEntities = lectureRepository.findByCategory_CourseId(courseId);
        return convertToDtoList(lectureEntities);
    }

    private List<LectureDto> convertToDtoList(List<LectureEntity> entityList) {
        return entityList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private LectureDto convertToDto(LectureEntity entity) {
        LectureDto dto = new LectureDto();
        dto.setLectureId(entity.getLectureId());
        dto.setCourseId(entity.getCategory().getCourseId());  // Assuming you have getCategory() method in LectureEntity
        dto.setLectureTitle(entity.getLectureTitle());
        dto.setVideoUrl(entity.getVideoUrl());

        return dto;
    }

    public String save(LectureDto lectureDto) throws IOException {
        LectureEntity lectureEntity = new LectureEntity();

        // Set the lecture title and video URL
        lectureEntity.setLectureTitle(lectureDto.getLectureTitle());
        lectureEntity.setVideoUrl(lectureDto.getVideoUrl());

        // Set the associated category (course)
        CategoryEntity category = categoryRepository.getReferenceById(lectureDto.getCourseId());
        lectureEntity.setCategory(category);

        lectureRepository.save(lectureEntity);

        return "Tạo bài giảng thành công";
    }

}
