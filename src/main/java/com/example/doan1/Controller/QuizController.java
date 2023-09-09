package com.example.doan1.Controller;

import com.example.doan1.Service.CategoryService;
import com.example.doan1.Service.QuizService;
import com.example.doan1.dto.CategoryDto;
import com.example.doan1.dto.LectureDto;
import com.example.doan1.dto.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/study/admin/backend/quiz")
public class QuizController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    QuizService quizService;
    @GetMapping("upload")
    public String create(org.springframework.ui.Model model) {
        List<CategoryDto> courseList = categoryService.getAllCategoryDtos();
        model.addAttribute("courselist", courseList);
        return "/jsp/quiz.jsp";
    }
    @PostMapping(value = "save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save( @ModelAttribute("quizDto")QuizDto quizDto, BindingResult bindingResult
                       , RedirectAttributes redirectAttributes ) throws IOException {
        if (bindingResult.hasErrors()) {
            return "/jsp/category.jsp";
        }

        quizService.save(quizDto);

        // Use the correct redirect URL33
        return "redirect:/study/admin/backend/quiz/upload";
    }
}
