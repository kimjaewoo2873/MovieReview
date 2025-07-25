package com.example.MovieReview.controller;

import com.example.MovieReview.dto.MemberForm;
import com.example.MovieReview.dto.MovieForm;
import com.example.MovieReview.entity.Movie;
import com.example.MovieReview.service.MemberService;
import com.example.MovieReview.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Slf4j
@Controller
public class MovieController {
    @Autowired
    MovieService movieService;
    @Autowired
    MemberService memberService;

    @GetMapping("/movie/new/{id}")
    public String pluspage(@PathVariable Long id, Model model) {
        log.info("아이디=" + String.valueOf(id));
        MemberForm memberForm = memberService.findId(id);
        log.info(memberForm.toString());
        model.addAttribute("MemberId", memberForm.getId());
        return "home/new";
    }

    @PostMapping("/movie/plus/{id}")
    public String plusMovie(MovieForm movieForm, @PathVariable Long id, @RequestParam("imageFile")MultipartFile imageFile, Model model) {
        log.info("plusMovie 호출 전");
        Movie movie = movieService.plusMovie(movieForm, id, imageFile);
        log.info("plusMovie 호출 후: {}", movie);

//        Movie movie = movieService.plusMovie(movieForm, id, imageFile); // 이 아이디는 멤버의 아이디여야함
        //log.info(movie.toString());
        List<MovieForm> movieForms = movieService.getList();
        model.addAttribute("MovieDtos", movieForms);
        return "redirect:/getlist/" + id;
    }

}
