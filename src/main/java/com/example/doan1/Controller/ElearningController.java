package com.example.doan1.Controller;

import com.example.doan1.Service.CategoryService;
import com.example.doan1.Service.LectureService;
import com.example.doan1.Service.QuizService;
import com.example.doan1.Service.UserService;
import com.example.doan1.dto.CategoryDto;
import com.example.doan1.dto.LectureDto;
import com.example.doan1.dto.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller// nếu return về jsp thì phải dùng controlelr
@RequestMapping("/study")
public class ElearningController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private LectureService lectureService;
    @Autowired
    private UserService userService;
    @Autowired
    QuizService quizService;
    @GetMapping("home")
    public String list(Model model,
                       @RequestParam(name = "name",
                               required = false) String name){
        //model: chuyền biến từ java -> jsp
        Object obj= null;
        if(name==null){
            obj=categoryService.findAll();
        }
        model.addAttribute("title", name);
        model.addAttribute("list", obj);
        return "/jsp/home.jsp";
    }
    @GetMapping("/home/course{courseId}")
    public String course(@PathVariable Integer courseId, Model model){
        CategoryDto courseDto = categoryService.getCategoryDtoById(courseId);
        model.addAttribute("courseDto", courseDto);
        return "/jsp/user/course.jsp";

    }
    @GetMapping("/home/course{courseId}/lectures")
    public String showCourseDetails(@PathVariable Integer courseId, Model model) {
        CategoryDto courseDto = categoryService.getCategoryDtoById(courseId);
        List<LectureDto> lectures = lectureService.getLecturesByCourseId(courseId);

        model.addAttribute("courseDto", courseDto);
        model.addAttribute("lectures", lectures);
        return"/jsp/lecture.jsp"; // Return the JSP page name without the prefix/suffix
    }
    @GetMapping("/home/course{courseId}/quizs")
    public String showQuizDetails(@PathVariable Integer courseId, Model model) {
        CategoryDto courseDto = categoryService.getCategoryDtoById(courseId);
        List<QuizDto> quizDtos=quizService.QuizByCourseId(courseId);
        model.addAttribute("courseDto", courseDto);
        model.addAttribute("quizDtos", quizDtos);
        return"/jsp/user/listquiz.jsp"; // Return the JSP page name without the prefix/suffix
    }
    @GetMapping("/home/login")
    public String login(@RequestParam(name = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("loginError", true);
        }
        return "/jsp/login.jsp";
    }
    @GetMapping("/home/signup")
    public String signup(Model model) {
        model.addAttribute("title","tạo mới tài khoản");

        return "/jsp/signup.jsp";
    }
}