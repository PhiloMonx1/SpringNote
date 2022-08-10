package com.example.springnote.controller;

import com.example.springnote.dto.CommitRequestDto;
import com.example.springnote.dto.CommitResponseDto;
import com.example.springnote.model.Commit;
import com.example.springnote.service.CommitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommitController {
    private final CommitService commitService;

    @PostMapping("/api/commit/{postId}")
    public Commit creatCommit(@PathVariable Long postId, @RequestBody CommitRequestDto commitRequestDto){
        return commitService.createCommit(postId,commitRequestDto);
    }

    @GetMapping("/api/commit/{postId}")
    public List<CommitResponseDto> getCommit(){
        return commitService.getCommit();
    }
    @PutMapping("/api/commit/{postId}")
    public Long update(@PathVariable Long postId,@RequestBody CommitRequestDto commitRequestDto) {
        commitService.update(postId, commitRequestDto);
        return postId;
    }
    @DeleteMapping("/api/commit/{postId}")
    public Long deleteCommit (@PathVariable Long postId){
        commitService.deleteCommit(postId);
        return postId;

    }

}
