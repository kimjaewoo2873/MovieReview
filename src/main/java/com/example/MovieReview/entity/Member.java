package com.example.MovieReview.entity;

import com.example.MovieReview.dto.MemberForm;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String password;

    public MemberForm createDto(Member target) {
        return new MemberForm(target.getId(), target.name, target.getPassword());
    }
}
