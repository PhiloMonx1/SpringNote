package com.example.springnote.dto;

import com.example.springnote.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class PostResponseDto {
    private Long id;
    private String userWriter;
    private String title;
    private String content;
    private int likes;

    public PostResponseDto(Post post){
        this.id = post.getId();
        this.userWriter = post.getUserWriter();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.likes = post.getLikes();
    }
}
