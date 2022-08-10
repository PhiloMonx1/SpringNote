package com.example.springnote.dto;

import com.example.springnote.model.Commit;
import lombok.Getter;


@Getter
public class CommitResponseDto {
    private Long id;

    private String userWriter;
    private String content;
    private int likes;

    public CommitResponseDto(Commit commit) {
        this.id = commit.getId();
        this.userWriter = commit.getUserWriter();
        this.content = commit.getContent();
        this.likes = commit.getLikes();
    }
}


