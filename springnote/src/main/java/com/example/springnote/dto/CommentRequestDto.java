package com.example.springnote.dto;

import com.example.springnote.model.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private String userWriter;
    private String content;
    private int likes;


}
