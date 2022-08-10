package com.example.springnote.service;

import com.example.springnote.dto.CommitRequestDto;
import com.example.springnote.dto.CommitResponseDto;
import com.example.springnote.model.Comment;
import com.example.springnote.model.Commit;
import com.example.springnote.model.Post;
import com.example.springnote.model.Users;
import com.example.springnote.repository.CommentRepository;
import com.example.springnote.repository.CommitRepository;
import com.example.springnote.repository.PostRepository;
import com.example.springnote.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommitService {
    private final CommitRepository commitRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;

    public Commit createCommit(Long PostId , CommitRequestDto commitRequestDto) {
        Users users = usersRepository.findById(commitRequestDto.getUserWriter())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Comment comment = commentRepository.findById(PostId)
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Commit commit = new Commit(commitRequestDto,users,comment);
        users.addCommit(commit);
        comment.addCommit(commit);
        return commitRepository.save(commit);
    }

    public List<CommitResponseDto> getCommit(){
        List<CommitResponseDto> commitResponseDtoList = new ArrayList<>();
        List<Commit> commit = commitRepository.findAll();
        for (Commit commit1:commit)
            commitResponseDtoList.add(new CommitResponseDto(commit1));
        return  commitResponseDtoList;
    }
    @Transactional
    public void update(Long postId, CommitRequestDto commitRequestDto) {
        Commit commit = commitRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("댓글이 없습니다"));
        commit.update(commitRequestDto);
    }

    public void deleteCommit(Long postId) {

        Comment comment = commentRepository.findById(postId)
                .orElseThrow(() ->new IllegalArgumentException("해당 댓글이 없습니다"));
        Users users = usersRepository.findById(comment.getUsers().getUsername())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Commit commit = commitRepository.findById(postId)
                .orElseThrow(()->new IllegalArgumentException("대댓글이 없습니다"));

        users.removeCommit(commit);
        comment.removeCommit(commit);
        commitRepository.delete(commit);

    }
}
