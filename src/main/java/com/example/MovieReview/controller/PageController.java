package com.example.MovieReview.controller;

import com.example.MovieReview.dto.MemberForm;
import com.example.MovieReview.dto.MovieForm;
import com.example.MovieReview.entity.Member;
import com.example.MovieReview.service.MemberService;
import com.example.MovieReview.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@Slf4j
public class PageController {
    @Autowired
    MemberService memberService;
    @Autowired
    MovieService movieService;

    @GetMapping("/home/login") // 로그인 홈 화면
    public String loginHome() {
        return "home/loginpage";
    }

    @PostMapping("/golist") // 로그인 후, 리스트 가져올거임
    public String index(MemberForm memberForm, Model model) {
        log.info(memberForm.toString());
        Member member = memberService.createMember(memberForm);
        memberForm.setId(member.getId());  // 저장된 ID를 memberForm에 세팅!
        return "redirect:/getlist/" + member.getId();
    }

    @GetMapping("/getlist/{id}")
    public String originList(@PathVariable Long id, Model model) {
        List<MovieForm> movieForms = movieService.getList();
        MemberForm memberForm = memberService.findId(id);
        model.addAttribute("MemberDto", memberForm);
        model.addAttribute("MovieDtos", movieForms);

        return "home/list";
    }

    @GetMapping("/home/infopage/{movieId}")
    public String showMovieDetail(@PathVariable Long movieId,
                                  @RequestParam(name = "viewerId", required = false) Long viewerId,
                                  Model model) {
        MovieForm dto = movieService.findId(movieId); // 영화 찾기
        log.info("영화 id : " + String.valueOf(dto.getMemberId()));
        log.info("viewerId : " + viewerId);
        model.addAttribute("InfoMovie", dto);
        model.addAttribute("viewerId", viewerId); // 이걸 목록 돌아가기 버튼에서 활용!
        return "home/movieinfo";
    }
}
