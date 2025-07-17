package com.example.MovieReview.service;

import com.example.MovieReview.dto.MemberForm;
import com.example.MovieReview.entity.Member;
import com.example.MovieReview.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Member createMember(MemberForm memberForm) {
        log.info(memberForm.toString());
        Member member = memberForm.toEntity();
        log.info(member.toString());
        Member saved = memberRepository.save(member);
        log.info("Saved Member ID: {}", saved.getId());
        log.info(saved.toString());
        return saved;
    }

    public MemberForm findId(Long id) {
        Member target = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("일치하는" +
                "id를 못 찾음"));
        MemberForm memberForm = target.createDto(target); // dto 변환
        return memberForm;
    }
}
