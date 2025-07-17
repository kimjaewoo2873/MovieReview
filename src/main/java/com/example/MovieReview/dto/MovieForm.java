package com.example.MovieReview.dto;

import com.example.MovieReview.entity.Member;
import com.example.MovieReview.entity.Movie;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieForm {
    private Long id;
    private Member memberId;
    private String title;
    private String score;
    private String memberName;
    private String imageUrl;

    public static MovieForm createDto(Movie m) {
        return new MovieForm(m.getId(), m.getMemberId(),m.getTitle(), m.getScore(), m.getMemberId().getName(), m.getImageUrl());
    }

    public Movie toEntity() {
        return  new Movie(this.id, this.memberId, this.title, this.score, this.imageUrl);
    }
}
