package com.example.springnote.service;

import com.example.springnote.dto.PostRequestDto;
import com.example.springnote.dto.PostResponseDto;
import com.example.springnote.model.Post;
import com.example.springnote.model.Users;
import com.example.springnote.repository.PostRepository;
import com.example.springnote.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;



    public Post creatPost(PostRequestDto postRequestDto) {
        Users users = usersRepository.findById(postRequestDto.getUserWriter())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Post post = new Post(postRequestDto,users);
        users.addPost(post);
        return postRepository.save(post);
    }

    public List<PostResponseDto> getPost() {
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        List<Post> post = postRepository.findAll();
        for (Post post1:post)
            postResponseDtoList.add(new PostResponseDto(post1));
        return postResponseDtoList;
    }

    @Transactional
    public void update(Long postId, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
         post.update(postRequestDto);
    }

    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다"));
        Users users = usersRepository.findById(post.getUsers().getUsername())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        users.removePost(post);
        postRepository.delete(post);
    }

}

