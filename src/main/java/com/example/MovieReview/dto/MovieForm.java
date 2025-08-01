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
    private String infoText;
    private String openDay;
    private String limitAge;
    private String genre;
    private String country;
    private String runningTime;
    private String company;
    private boolean isWrite;

    public static MovieForm createDto(Movie m, Member loginMember) {
        boolean isWriter = m.getMemberId().getId().equals(loginMember.getId());
        // 또는 이름 비교도 가능
        return new MovieForm(m.getId(), m.getMemberId().getId(), m.getTitle(), m.getScore(),
                m.getMemberId().getName(), m.getImageUrl(), m.getInfoText(), m.getOpenDay(),
                m.getLimitAge(), m.getGenre(), m.getCountry(), m.getRunningTime(),
                m.getCompany(), isWriter);
    }

    public static void editMovieInfo(MovieForm target, MovieForm editMovie) {
        if(!target.getTitle().equals(editMovie.getTitle())) {
           target.getTitle() = editMovie.getTitle();
        }
    }


    public Movie toEntity(Member member) {
        log.info("현재 추가된 무비 this.id = " + this.id);
        return new Movie(null, member, this.title, this.score, this.imageUrl, this.infoText, this.openDay, this.limitAge,
                this.genre, this.country, this.runningTime, this.company);
    }

    public void setIsWrite(boolean isWrite) {
        this.isWrite = isWrite;
    } // 수정을 위한, 작성자 찾기
}
