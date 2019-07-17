package com.sda.finalproject.plantwatering.blog.controllers;

import com.sda.finalproject.plantwatering.blog.models.User;
import com.sda.finalproject.plantwatering.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    private String getWelcomePage() {
        return "index";
    }

    @GetMapping("/login")
    private String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    private String getNewUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "signup";
    }

    @PostMapping("/signup")
    private String createNewUser(User user, Model model) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        model.addAttribute("saveOk", "User successfully registered! Please login!");
        model.addAttribute("newUser", new User());
        return "index";
    }
}
