package com.example.MovieReview.controller;

import com.example.MovieReview.dto.MemberForm;
import com.example.MovieReview.dto.MovieForm;
import com.example.MovieReview.service.MemberService;
import com.example.MovieReview.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@Slf4j
public class PageController {
    @Autowired
    MemberService memberService;
    @Autowired
    MovieService movieService;

    @GetMapping("/home/login") // 로그인 홈 화면
    public String loginHome() {
        return "home/loginpage";
    }
    @PostMapping("/golist") // 로그인 후, 리스트 가져올거임
    public String index(MemberForm memberForm, Model model) {
        memberService.createMember(memberForm);
        List<MovieForm> movieForms = movieService.getList();
        model.addAttribute("MovieDtos", movieForms);
        return "home/list";
    }

}
