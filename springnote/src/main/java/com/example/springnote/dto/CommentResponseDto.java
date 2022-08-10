package com.example.springnote.dto;

import com.example.springnote.model.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private Long id;

    private String userWriter;
    private String content;
    private int likes;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.userWriter = comment.getUserWriter();
        this.content = comment.getContent();
        this.likes = comment.getLikes();
    }
}
