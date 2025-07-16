package com.example.MovieReview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {
    @GetMapping("/home/login")
    public String login() {
        return "home/loginpage";
    }
}
