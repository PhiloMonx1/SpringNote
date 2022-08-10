package com.example.springnote.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String userWriter;
    private String title;
    private String content;
    private int likes;

}
