package com.example.doan1.Controller;

import com.example.doan1.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller// nếu return về jsp thì phải dùng controlelr
@RequestMapping("/study")
public class ElearningController {
    @Autowired
    private CategoryService categoryService;
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
    @GetMapping("login")
    public String login() {
        return "/jsp/login.jsp";
    }
    @GetMapping("signup")
    public String signup() {
        return "/jsp/signup.jsp";
    }
}