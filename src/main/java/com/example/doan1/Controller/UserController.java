package com.example.doan1.Controller;

import com.example.doan1.Service.UserService;
import com.example.doan1.dto.UserDto;
import com.example.doan1.entities.UserEntity;
import com.example.doan1.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/study/home/signup")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
    @PostMapping(value = "save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save(UserDto userDto, Model model, RedirectAttributes redirectAttributes) {
        if (userService.isEmailAlreadyExists(userDto.getUserEmail())) {
            redirectAttributes.addFlashAttribute("error", "Email already exists!");
            return "redirect:/study/home/signup"; // Redirect back to the registration page
        }

        userService.save(userDto);
        redirectAttributes.addFlashAttribute("success", "New user submitted successfully!");
        return "redirect:/study/home/signup/list";

    }}
