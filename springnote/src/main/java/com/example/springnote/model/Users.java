package com.example.springnote.model;


import com.example.springnote.dto.SignupRequestDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany
    @JsonManagedReference
    private List<Post> postList = new ArrayList<>();

    @OneToMany
    private List<Comment> commentList = new ArrayList<>();


    @OneToMany
    private List<Commit> commitList = new ArrayList<>();

    public Users(SignupRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
    }

    public void addPost(Post post) {
        this.postList.add(post);
    }

    public void removePost(Post post) {
        this.postList.remove(post);
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }
    public void removeComment(Comment comment) {
        this.commentList.remove(comment);
    }
    public void  addCommit (Commit commit){
        this.commitList.add(commit);
    }
    public void removeCommit(Commit commit){
        this.commitList.remove(commit);
    }
}


