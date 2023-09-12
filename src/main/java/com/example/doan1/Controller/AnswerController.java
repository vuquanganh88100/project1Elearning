package com.example.doan1.Controller;

import com.example.doan1.Service.AnswerService;
import com.example.doan1.Service.ExamService;
import com.example.doan1.Service.QuizService;
import com.example.doan1.Service.UserService;
import com.example.doan1.dto.AnswerDto;
import com.example.doan1.dto.ExamDto;
import com.example.doan1.dto.QuizDto;
import com.example.doan1.dto.UserDto;
import com.example.doan1.entities.UserEntity;
import com.example.doan1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/study/home")
public class AnswerController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    QuizService quizService;
    @Autowired
    ExamService examService;
    @Autowired
    AnswerService answerService;
    @Autowired
    UserService userService;
    @GetMapping("/quiz{quizId}")
public String showQuizDetails(@PathVariable Integer quizId,Model model) {
    QuizDto quizDto = quizService.getQuizDtoById(quizId);
    List<ExamDto> examDtoList = examService.getExamsByQuizId(quizId);
    model.addAttribute("quizDto", quizDto);
    model.addAttribute("examDtoList", examDtoList);

    AnswerDto answerDto = new AnswerDto();
//        answerDto.setQuizId(quizId);

    // Initialize selectedAns and correctAns lists with the same size
    List<String> selectedAns = new ArrayList<>();
    List<String> correctAns = new ArrayList<>();
    for (ExamDto exam : examDtoList) {
        selectedAns.add("");
        correctAns.add(exam.getCorrectAns());
    }
    answerDto.setSelectedAns(selectedAns);
    answerDto.setCorrectAns(correctAns);

    model.addAttribute("answerDto", answerDto);
    return "/jsp/user/answer.jsp";
}
    //    @RequestParam(value = "quizId",required = false)Integer quizId,
    @PostMapping(value = "save")
    public String save(@ModelAttribute AnswerDto answerDto ,BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "/jsp/user/answer.jsp";
        }
//        int correctAnswerCount = 0;
//        for (Boolean isCorrect : answerDto.getAnswerResults()) {
//            if (isCorrect) {
//                correctAnswerCount++;
//            }
//        }
        // Retrieve the userEmail from Spring Security's Authentication object
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        // Fetch the userId using the userEmail from the UserService
        Integer userId = userService.getUserId(userEmail);

        // Set the userId in the AnswerDto
        answerDto.setUserId(userId);
        System.out.println("UserId: " + userId);
        answerService.checkAnswers(answerDto);
        double score=answerService.calculateScore(answerDto.getAnswerResults(),answerDto.getSelectedAns().size());
        answerDto.setScore(score);
        answerService.save(answerDto);
        // Use the correct redirect URL33
        return "/jsp/user/congratulation.jsp";
    }

}

