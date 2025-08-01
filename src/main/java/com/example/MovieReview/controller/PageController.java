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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/signup")
    public String signUpPage() {
        return "home/signuppage";
    }

    @PostMapping("/golist/signup") // 회원가입 후, 리스트 가져올거임
    public String index1(MemberForm memberForm, Model model, RedirectAttributes rttr) {
        Member check = memberService.checkLogin(memberForm.getName(), memberForm.getPassword());
        if(check != null) {
            log.info("회원가입 실패, 중복");
            rttr.addFlashAttribute("msg", "이미 가입된 아이디입니다.");
            return "redirect:/home/login";
        }

        Member member = memberService.createMember(memberForm);
        memberForm.setId(member.getId());  // 저장된 ID를 memberForm에 세팅!
        return "redirect:/getlist/" + member.getId();
    }

    @PostMapping("/golist") // 로그인 후, 리스트 가져올거임
    public String index2(MemberForm memberForm, Model model, RedirectAttributes rttr) {
        Member check = memberService.checkLogin(memberForm.getName(), memberForm.getPassword());
        if(check == null) {
            log.info("로그인 실패");
            rttr.addFlashAttribute("msg", "아이디, 비밀번호가 틀립니다.");
            return "redirect:/home/login";
        }
        //log.info(memberForm.toString());
        memberForm.setId(check.getId());  // 저장된 ID를 memberForm에 세팅!
        return "redirect:/getlist/" + check.getId();
    }

    @GetMapping("/getlist/{id}") // 로그인 아이디로 리스트 가져오기, id는 member
    public String originList(@PathVariable Long id, Model model) {
        List<MovieForm> movieForms = movieService.getList(id);
        MemberForm memberForm = memberService.findId(id);
        model.addAttribute("MemberDto", memberForm);
        model.addAttribute("MovieDtos", movieForms);
        movieService.findMemberWrite(memberForm, movieForms);

        return "home/list";
    }

    @GetMapping("/home/infopage/{movieId}") // 상세 목록 페이지
    public String showMovieDetail(@PathVariable Long movieId,
                                  @RequestParam(name = "viewerId", required = false) Long viewerId,
                                  Model model) {
        MovieForm dto = movieService.findId(movieId, viewerId); // 영화 찾기
        log.info("영화 id : " + String.valueOf(dto.getMemberId()));
        log.info("viewerId : " + viewerId);
        model.addAttribute("InfoMovie", dto);
        model.addAttribute("viewerId", viewerId); // 이걸 목록 돌아가기 버튼에서 활용!
        return "home/movieinfo";
    }

    @GetMapping("/edit/{movieId}") // edit 페이지
    public String editMovieInfo(@PathVariable Long movieId,
                            @RequestParam(name = "viewerId", required = false) Long viewerId,
                            Model model) {
        MovieForm dto = movieService.findId(movieId, viewerId);
        model.addAttribute("editMovie", dto);
        model.addAttribute("viewerId", viewerId);
        return "home/edit";
    }

    @PostMapping("/movie/edit/{viewerId}")
    public String editMovie(@PathVariable Long viewerId, MovieForm movieForm) {
        MovieForm edit = movieService.editMovie(movieForm);

        return "redirect:/getlist/" + viewerId;
    }
}
