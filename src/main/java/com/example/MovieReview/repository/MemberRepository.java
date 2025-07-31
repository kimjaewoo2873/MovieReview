package com.example.MovieReview.repository;


import com.example.MovieReview.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT * FROM member WHERE name = :name AND password = :password", nativeQuery = true)
    Member findUser(@Param("name") String name, @Param("password") String password);
}
