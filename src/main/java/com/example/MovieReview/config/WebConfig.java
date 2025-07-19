package com.example.MovieReview.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// Spring Boot 웹 서버가 c드라이브의 images 폴더를 정적 자원 경로로 등록해서,
// 웹에서 /images/파일명 으로 접근 가능하게 만들어주는 설정
@Configuration  // Spring 설정 파일임을 나타내는 클래스
public class WebConfig implements WebMvcConfigurer { // WebMvcConfigurer은 Sptring MVC 설정을 커스터마이징 할 수 있게 하주는 인터페이스
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**") // 웹 브라우저에서 /images/파일명 으로 요청이 들어왔을때
                .addResourceLocations("file:///c:/images/"); // 로컬 디스크 c:/images/ 폴더에서 파일을 찾도록 지정
    }
}
