package com.example.doan1.Service;

import com.example.doan1.dto.CategoryDto;
import com.example.doan1.entities.CategoryEntity;
import com.example.doan1.repository.CategoryRepository;

import com.example.doan1.utils.FileUtils;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public CategoryDto getCategoryDtoById(Integer categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        return convertToDto(categoryEntity);
    }// find courseID tương ứng , nếu có trả về list lecture của courseID đó

    public String save(CategoryDto categoryDto) throws IOException {
        CategoryEntity categoryEntity = new CategoryEntity();
        String filePath = String.valueOf(FileUtils.saveFileFromMultiPartFile(categoryDto.getImageFile()));
        categoryDto.setCourseImage(filePath);

        // Manually copy properties from DTO to Entity
        categoryEntity.setCourseName(categoryDto.getCourseName());
        categoryEntity.setCourseImage(categoryDto.getCourseImage());
        categoryEntity.setCourseImage(filePath);
        // Copy other properties in a similar manner

        categoryRepository.save(categoryEntity);

        return "Tạo tài khoản mới thành công";
    }

    public List<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }
    public List<CategoryDto> getAllCategoryDtos() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return convertToDtoList(categoryEntities);
    }

    private List<CategoryDto> convertToDtoList(List<CategoryEntity> entityList) {
        return entityList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CategoryDto convertToDto(CategoryEntity entity) {
        CategoryDto dto = new CategoryDto();
        dto.setCourseId(entity.getCourseId());
        dto.setCourseName(entity.getCourseName());
        dto.setCourseImage(entity.getCourseImage());

        // You can add more properties as needed

        return dto;
    }


}