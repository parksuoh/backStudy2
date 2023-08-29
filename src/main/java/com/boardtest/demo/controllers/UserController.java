package com.boardtest.demo.controllers;

import com.boardtest.demo.applications.GetCheckUserNameService;
import com.boardtest.demo.applications.LoginService;
import com.boardtest.demo.applications.RegisterService;
import com.boardtest.demo.dtos.LoginRequestDto;
import com.boardtest.demo.dtos.RegisterRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final GetCheckUserNameService getCheckUserNameService;
    private final RegisterService registerService;
    private final LoginService loginService;

    public UserController(GetCheckUserNameService getCheckUserNameService, RegisterService registerService, LoginService loginService) {
        this.getCheckUserNameService = getCheckUserNameService;
        this.registerService = registerService;
        this.loginService = loginService;
    }


    // TODO: 회원가입
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody RegisterRequestDto registerRequestDto) {
        String res = registerService.register(registerRequestDto.getName(), registerRequestDto.getPassword());
        return res;
    }


    // TODO: 로그인
    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequestDto loginRequestDto) {
        boolean res = loginService.login(loginRequestDto.getName(), loginRequestDto.getPassword());
        return res;
    }

    // TODO: 아이디 확인
    @GetMapping("/check-user-name")
    public boolean checkUserName(@RequestParam String name) {

        return getCheckUserNameService.checkUserName(name);
    }
}
