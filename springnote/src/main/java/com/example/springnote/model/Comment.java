package com.example.springnote.model;

import com.example.springnote.dto.CommentRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
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
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;


    @OneToMany
    @JsonManagedReference
    private List<Commit> commitList = new ArrayList<>();

    public Comment(CommentRequestDto commentRequestDto, Users users , Post post) {
        this.userWriter = users.getUsername();
        this.content = commentRequestDto.getContent();
        this.likes = commentRequestDto.getLikes();
        this.users = users;
        this.post = post;
    }

    public void update(CommentRequestDto commentRequestDto) {
        this.userWriter = users.getUsername();
        this.content = commentRequestDto.getContent();
        this.likes = commentRequestDto.getLikes();
    }

    public void addCommit(Commit commit) {
        this.commitList.add(commit);

    }

    public void removeCommit(Commit commit) {
        this.commitList.remove(commit);
    }
}
