package com.example.MovieReview.dto;

import com.example.MovieReview.entity.Member;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MemberForm {
    private Long id;
    private String name;
    private String password;

    public Member toEntity() {
        return new Member(id, name, password);
    }
}
