package com.example.MovieReview.controller;

import com.example.MovieReview.dto.MovieForm;
import com.example.MovieReview.entity.Movie;
import com.example.MovieReview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/movie/new")
    public String pluspage() {
        return "home/new";
    }
    @GetMapping("/movie/plus")
    public String plusMovie(MovieForm movieForm) {
        Movie movie = movieService.plus(movieForm);
        return "home/list";
    }

}
