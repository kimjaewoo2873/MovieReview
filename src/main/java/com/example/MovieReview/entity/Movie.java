package com.example.MovieReview.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member memberId;

    @Column
    private String title;

    @Column
    private double score;

    @Column
    private String imageUrl;

    @Column
    private String infoText;

    @Column
    private String openDay;

    @Column
    private String limitAge;

    @Column
    private String genre;

    @Column
    private String country;

    @Column
    private String runningTime;

    @Column
    private String company;

}
