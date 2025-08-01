package com.example.MovieReview.repository;

import com.example.MovieReview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT * FROM movie", nativeQuery = true)
    List<Movie> findMovie();

}
