package com.example.doan1.Controller;

import com.example.doan1.Service.CategoryService;
import com.example.doan1.Service.UserService;
import com.example.doan1.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/study/admin/backend")
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("upload")
    public String create(Model model,@RequestParam(name = "name",
            required = false) String name) {
        model.addAttribute("title", "Tạo khóa học mới");
        model.addAttribute("categoryDto", new CategoryDto());
        return "/jsp/category.jsp";
    }
    @GetMapping("home")
    public String signup(Model model) {
        model.addAttribute("title","tạo mới tài khoản");

        return "/jsp/admin.jsp";
    }
    @PostMapping(value = "save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String save(@ModelAttribute("categoryDto") CategoryDto categoryDto, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            return  "/jsp/category.jsp";
        }
        categoryService.save(categoryDto);

        redirectAttributes.addFlashAttribute("message", "Tạo  thành công!");
        redirectAttributes.addFlashAttribute("list", categoryDto); // Add the list attribute

        return "redirect:/study/home";
    }
    @Autowired
    UserService userService;
    @GetMapping("/user/list")// Phương thức Get: Lấy dữ liệu ==> load trang ra dự form có sẵn trước
//    @ResponseBody// trả về dạng json
    public String list(Model model,
                       @RequestParam(name = "name",
                               required = false) String name){
        //model: chuyền biến từ java -> jsp

        Object obj= null;
        if(name==null){
            obj=userService.findAll();
        }
        model.addAttribute("title", name);
        model.addAttribute("user", obj);
        return "/jsp/userlist.jsp";
    }

}