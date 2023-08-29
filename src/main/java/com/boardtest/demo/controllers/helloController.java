package com.boardtest.demo.controllers;

import com.boardtest.demo.models.QUser;
import com.boardtest.demo.models.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.boardtest.demo.models.QUser.user;


@RestController
@RequestMapping("/hello")
public class helloController {

    private final PasswordEncoder passwordEncoder;

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public helloController(PasswordEncoder passwordEncoder, EntityManager em) {
        this.passwordEncoder = passwordEncoder;
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @GetMapping("/")
    public boolean hello() {
        String encodedPass = passwordEncoder.encode("hello");

        return passwordEncoder.matches("hello", encodedPass);
    }


    @GetMapping("/dsl")
    public String dsl() {

        User resultUser = queryFactory
                .select(user)
                .from(user)
                .where(user.name.eq("aaaa"))
                .fetchOne();

        return resultUser.password();
    }
}
