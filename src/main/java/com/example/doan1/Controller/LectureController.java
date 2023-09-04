package com.example.doan1.Controller;

import com.example.doan1.Service.CategoryService;
import com.example.doan1.Service.LectureService;
import com.example.doan1.dto.CategoryDto;
import com.example.doan1.dto.LectureDto;
import com.example.doan1.entities.CategoryEntity;
import com.example.doan1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/study/admin/backend/lecture")
public class LectureController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private LectureService lectureService;
    @GetMapping("upload")
    public String create(Model model) {
        List<CategoryDto> courseList = categoryService.getAllCategoryDtos();
        model.addAttribute("courseList", courseList);
        return "/jsp/uplecture.jsp";
    }
    @PostMapping(value = "save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save(@ModelAttribute("lectureDto") LectureDto lectureDto, BindingResult bindingResult,
                       Model model, RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            return "/jsp/category.jsp";
        }

        lectureService.save(lectureDto);

        // Use the correct redirect URL
        return "redirect:/study/admin/backend/lecture/upload";
    }

}
