package com.example.MovieReview.service;

import com.example.MovieReview.dto.MovieForm;
import com.example.MovieReview.entity.Member;
import com.example.MovieReview.entity.Movie;
import com.example.MovieReview.repository.MemberRepository;
import com.example.MovieReview.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MemberRepository memberRepository;

    // 중복 파일 이름 번호 붙히기
    private String getUniqueFileName(String uploadDir, String originalFilename) {
        File file = new File(uploadDir + originalFilename);
        if (!file.exists()) {
            return originalFilename; // 중복 없으면 원본 파일명 반환
        }

        String name = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));

        int count = 1;
        String newFilename;

        while (true) {
            newFilename = name + "(" + count + ")" + extension;
            file = new File(uploadDir + newFilename);
            if (!file.exists()) {
                break; // 존재하지 않는 파일명 발견 시 종료
            }
            count++;
        }
        return newFilename;
    }

    public Movie plusMovie(MovieForm movieForm, Long id, MultipartFile imageFile) {
        if (!imageFile.isEmpty()) {
            String uploadDir = "c:/images/";
            String originalFilename = imageFile.getOriginalFilename(); // 원본 파일 이름
            String savedName = getUniqueFileName(uploadDir, originalFilename);

            // 저장 경로에 파일 객체 생성
            File destFile = new File(uploadDir + savedName);
            try {
                if(!destFile.getParentFile().exists()) {
                    destFile.getParentFile().mkdirs();
                }
                // 업로드된 파일을 지정한 경로에 저장
                imageFile.transferTo(destFile);
                // 웹에서 접근할 이미지 URL 경로 생성 (예: /images/myphoto.jpg)
                String imageUrl = "/images/" + savedName;
                // movieForm 객체에 이미지 URL 세팅
                movieForm.setImageUrl(imageUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //log.info(movieForm.toString());
        // dto -> entity -> repository dto를 엔티티로 변환해야하는데, 엔티티에는 멤버 객체,
        // 지금 dto를 엔티티로 바꾸는데 member객체가 없음
        log.info("멤버 아이디=" +String.valueOf(id));
        Member target = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id를 찾지 못함"));
        log.info("멤버 타겟=" + target.toString());

        Movie movie = movieForm.toEntity(target); // imageUrl 포함해서 Entity 변환
        log.info("movieForm " + movieForm.toString());
        log.info("movie 엔터티 변환" + movie.toString());

        Movie saved = movieRepository.save(movie);
        //log.info(saved.toString());

        return saved;
    }

    public List<MovieForm> getList() {
        List<Movie> entityList = movieRepository.findMovie();
        List<MovieForm> dtos = new ArrayList<MovieForm>();
        for(int i=0;i<entityList.size();i++) {
            Movie entity = entityList.get(i);
            //log.info(entity.toString());
            MovieForm movieDto = MovieForm.createDto(entity);
            //log.info(movieDto.toString());
            dtos.add(movieDto);
        }
        return dtos;
    }

    public MovieForm findId(Long id) {
        Movie target = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID에 맞는 영화를 " +
                "찾을 수 없음"));
        MovieForm movieForm = MovieForm.createDto(target);
        return movieForm;
    }
}
