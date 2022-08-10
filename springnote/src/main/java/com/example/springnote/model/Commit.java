package com.example.springnote.model;

import com.example.springnote.dto.CommitRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Commit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String userWriter;

    @Column(nullable = false)
    private String content;

    private int likes;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "USER_ID", nullable = false)
    private Users users;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "COMMENT_ID", nullable = false)
    private Comment comment;

    public Commit(CommitRequestDto commitRequestDto, Users users, Comment comment){
        this.userWriter = users.getUsername();
        this.content = commitRequestDto.getContent();
        this.likes= commitRequestDto.getLikes();
        this.users = users;
        this.comment = comment;
    }

    public void update(CommitRequestDto commitRequestDto) {
        this.userWriter = users.getUsername();
        this.content = commitRequestDto.getContent();
        this.likes = commitRequestDto.getLikes();
    }
}
