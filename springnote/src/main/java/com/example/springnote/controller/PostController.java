package com.example.springnote.controller;



import com.example.springnote.dto.PostRequestDto;
import com.example.springnote.dto.PostResponseDto;
import com.example.springnote.model.Post;
import com.example.springnote.repository.PostRepository;
import com.example.springnote.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("/api/post")
    public Post creatPost(@RequestBody PostRequestDto postRequestDto){
        return  postService.creatPost(postRequestDto);
    }

    @GetMapping("/api/post")
    public List<PostResponseDto> getPost(){
        return postService.getPost();
    }

    @PutMapping("/api/post/{postId}")
    public Long update(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto){
        postService.update(postId,postRequestDto);
        return postId;
    }

    @DeleteMapping("/api/post/{postId}")
    public Long deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
        return postId;
    }

}

