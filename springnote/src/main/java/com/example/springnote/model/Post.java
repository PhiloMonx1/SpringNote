package com.example.springnote.model;

import com.example.springnote.dto.PostRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String userWriter;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private  int likes;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "USER_ID", nullable = false)
    private Users users;

    @OneToMany
    private List<Comment> commentList = new ArrayList<>();


    public Post(PostRequestDto postRequestDto, Users users) {
        this.userWriter = postRequestDto.getUserWriter();
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.likes = postRequestDto.getLikes();
        this.users = users;

    }

    public void update(PostRequestDto postRequestDto) {
        this.userWriter = postRequestDto.getUserWriter();
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.likes = postRequestDto.getLikes();
    }


    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }

    public void removeComment(Comment comment) {
        this.commentList.remove(comment);
    }



}
