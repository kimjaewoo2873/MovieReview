package com.example.MovieReview.dto;

import com.example.MovieReview.entity.Member;
import com.example.MovieReview.entity.Movie;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
public class MovieForm {
    private Long id;
    private Long memberId;
    private String title;
    private double score;
    private String memberName;
    private String imageUrl;

    public static MovieForm createDto(Movie m) {
        return new MovieForm(m.getId(), m.getMemberId().getId(), m.getTitle(), m.getScore(), m.getMemberId().getName(), m.getImageUrl());
    }

    public Movie toEntity(Member member) {
        log.info("현재 추가된 무비 this.id = " + this.id);
        return new Movie(null, member, this.title, this.score, this.imageUrl);
    }

}
