package com.example.springnote.controller;

import com.example.springnote.dto.CommentRequestDto;
import com.example.springnote.dto.CommentResponseDto;
import com.example.springnote.dto.PostRequestDto;
import com.example.springnote.model.Comment;
import com.example.springnote.model.Post;
import com.example.springnote.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;


    @PostMapping("/api/comment/{postId}")
    public Comment creatComment(@PathVariable Long postId , @RequestBody CommentRequestDto commentRequestDto){
        return commentService.creatComment(postId,commentRequestDto);
    }

    @GetMapping("/api/comment/{postId}")
    public List<CommentResponseDto> getComment(){
        return commentService.getComment();
    }

    @PutMapping("/api/comment/{postId}")
    public Long update(@PathVariable Long postId, @RequestBody CommentRequestDto commentRequestDto){
        commentService.update(postId,commentRequestDto);
        return postId;
    }

    @DeleteMapping("/api/comment/{postId}")
    public Long deleteComment(@PathVariable Long postId){
        commentService.deleteComment(postId);
        return postId;
    }
}

