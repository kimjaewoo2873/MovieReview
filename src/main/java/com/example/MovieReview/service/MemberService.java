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

    public void createMember(MemberForm memberForm) {
        log.info(memberForm.toString());
        Member member = memberForm.toEntity();
        log.info(member.toString());
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
    }
}
