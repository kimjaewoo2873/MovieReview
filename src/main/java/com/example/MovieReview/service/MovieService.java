package com.example.MovieReview.service;

import com.example.MovieReview.dto.MovieForm;
import com.example.MovieReview.entity.Movie;
import com.example.MovieReview.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie plus(MovieForm movieForm) {
        log.info(movieForm.toString());
        Movie movie = movieForm.toEntity();
        log.info(movie.toString());
        Movie saved = movieRepository.save(movie);
        log.info(saved.toString());
        return saved;
    }

    public List<MovieForm> getList() {
        List<Movie> entityList = movieRepository.findMovie();
        List<MovieForm> dtos = new ArrayList<MovieForm>();
        for(int i=0;i<entityList.size();i++) {
            Movie entity = entityList.get(i);
            MovieForm movieDto = MovieForm.createDto(entity);
            dtos.add(movieDto);
        }
        return dtos;
    }
}
