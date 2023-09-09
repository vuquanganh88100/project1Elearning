package com.example.doan1.Controller;

import com.example.doan1.Service.ExamService;
import com.example.doan1.Service.QuizService;
import com.example.doan1.dto.CategoryDto;
import com.example.doan1.dto.ExamDto;
import com.example.doan1.dto.QuizDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/study/admin/backend/exam")
public class ExamController {
    @Autowired
    ExamService examService;
    @Autowired
    QuizService quizService;
    @GetMapping("/upload")
    public String create(Model model) {
        List<QuizDto> quizDtos=quizService.getAllQuizDto();
        model.addAttribute("quizDtos",quizDtos);
        return "/jsp/upques.jsp";
    }
    @PostMapping(value = "save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save(
            @ModelAttribute("examDto") ExamDto examDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            @RequestParam("correctAns") String correctAns) throws IOException {
        if (bindingResult.hasErrors()) {
            return "/jsp/category.jsp";
        }

        switch (correctAns) {
            case "a":
                examDto.setCorrectAns(examDto.getOption1());
                break;
            case "b":
                examDto.setCorrectAns(examDto.getOption2());
                break;
            case "c":
                examDto.setCorrectAns(examDto.getOption3());
                break;
            case "d":
                examDto.setCorrectAns(examDto.getOption4());
                break;
            default:
                // Handle the case where no correct answer is selected
                // You can set a default behavior or throw an error here
                break;
        }

        examService.save(examDto);

        // Use the correct redirect URL
        return "redirect:/study/admin/backend/quiz/upload";
    }

//
//    @GetMapping("/getNumOfQuestions")
//    @ResponseBody
//    public ResponseEntity<Integer> getNumOfQuestions(@RequestParam("quizId") int quizId) {
//        QuizDto selectedQuiz = quizService.getQuizDtoById(quizId); // Retrieve the selected quiz
//        if (selectedQuiz != null) {
//            int numOfQuestions = selectedQuiz.getNumofQues();
//            return ResponseEntity.ok(numOfQuestions);
//        } else {
//            // Handle the case where the selected quiz is not found
//            return ResponseEntity.notFound().build();
//        }
//    }


}
