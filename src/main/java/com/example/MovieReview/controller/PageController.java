package com.example.MovieReview.controller;

import com.example.MovieReview.dto.MemberForm;
import com.example.MovieReview.dto.MovieForm;
import com.example.MovieReview.entity.Member;
import com.example.MovieReview.service.MemberService;
import com.example.MovieReview.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        log.info(memberForm.toString());
        Member member = memberService.createMember(memberForm);
        return "redirect:/getlist/" + member.getId();
    }

    @GetMapping("/getlist/{id}")
    public String originList(@PathVariable Long id, Model model) {
        List<MovieForm> movieForms = movieService.getList();
        MemberForm memberForm = memberService.findId(id);
        model.addAttribute("MemberDto", memberForm);
        model.addAttribute("MovieDtos", movieForms);
        return "home/list";
    }

    @GetMapping("/home/movieinfo/{id}")
    public String viewInfo(@PathVariable Long id, Model model) {
        MovieForm dto = movieService.findId(id);
        model.addAttribute("InfoMovie", dto);
        return "home/movieinfo";
    }
}
