package com.example.MovieReview.api;

import com.example.MovieReview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieApiController {
    @Autowired
    MovieService movieService;

}
