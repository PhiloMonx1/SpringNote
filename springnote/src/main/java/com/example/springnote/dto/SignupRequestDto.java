package com.example.springnote.dto;

import com.example.springnote.model.Users;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;


}
