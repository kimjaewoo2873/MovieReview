package com.example.MovieReview.api;

import com.example.MovieReview.dto.MovieForm;
import com.example.MovieReview.entity.Movie;
import com.example.MovieReview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MovieApiController {
    @Autowired
    MovieService movieService;

    @PostMapping(value = "api/movie/plus/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<MovieForm>> plusMovie(
            @PathVariable Long id,
            @RequestPart("movieForm") MovieForm movieForm,
            @RequestPart("imageFile") MultipartFile imageFile) {

        Movie movie = movieService.plusMovie(movieForm, id, imageFile);
        List<MovieForm> dtos = movieService.getList(id);
        return (dtos != null) ?
                ResponseEntity.status(HttpStatus.OK).body(dtos) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
