package com.example.springnote.controller;

import com.example.springnote.dto.SignupRequestDto;
import com.example.springnote.model.Users;
import com.example.springnote.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원가입 등록
    @PostMapping("/users/login")
    public Users registerUsers(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.registerUser(signupRequestDto);
    }

    // 회원 가입 페이지
    @GetMapping("/users/login/{usersname}")
    public Optional<Users> readUsers(@PathVariable String usersname) {
        return userService.readUsers(usersname);
    }



}



