package com.example.springnote.service;

import com.example.springnote.dto.CommentRequestDto;
import com.example.springnote.dto.CommentResponseDto;
import com.example.springnote.model.Comment;
import com.example.springnote.model.Post;
import com.example.springnote.model.Users;
import com.example.springnote.repository.CommentRepository;
import com.example.springnote.repository.PostRepository;
import com.example.springnote.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;
    public Comment creatComment(Long PostId, CommentRequestDto commentRequestDto) {
        Users users = usersRepository.findById(commentRequestDto.getUserWriter())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Post post = postRepository.findById(PostId)
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Comment comment = new Comment(commentRequestDto,users,post);
        users.addComment(comment);
        post.addComment(comment);
        return commentRepository.save(comment);
    }

    public List<CommentResponseDto> getComment() {
        List<CommentResponseDto>  commentResponseDtoList = new ArrayList<>();
        List<Comment> comment = commentRepository.findAll();
        for (Comment comment1:comment)
            commentResponseDtoList.add(new CommentResponseDto(comment1));
        return  commentResponseDtoList;


    }
    @Transactional
    public void update(Long postId, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("게시글이 없습니다"));
        comment.update(commentRequestDto);
    }

    public void deleteComment(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다"));
        Comment comment = commentRepository.findById(postId)
                .orElseThrow(() ->new IllegalArgumentException("해당 댓글이 없습니다"));
        Users users = usersRepository.findById(comment.getUsers().getUsername())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));

        users.removeComment(comment);
        post.removeComment(comment);
        commentRepository.delete(comment);
    }
}
