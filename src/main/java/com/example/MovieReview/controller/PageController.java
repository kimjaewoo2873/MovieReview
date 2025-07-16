package com.example.MovieReview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class pageController {
    @GetMapping("/home/login") // 로그인 홈 화면
    public String loginHome() {
        return "home/loginpage";
    }
    @PostMapping("/login") // 로그인 후, 리스트
    public String index(@RequestParam String id, @RequestParam String passwd) {
        return "home/list";
    }
}
