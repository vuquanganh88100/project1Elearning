package com.example.doan1.Service;

import com.example.doan1.dto.CategoryDto;
import com.example.doan1.entities.CategoryEntity;
import com.example.doan1.repository.CategoryRepository;

import com.example.doan1.utils.FileUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

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

}