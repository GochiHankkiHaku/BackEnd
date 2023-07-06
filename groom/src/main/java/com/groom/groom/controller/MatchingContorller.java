package com.groom.groom.controller;

import com.groom.groom.domain.Matching;

import com.groom.groom.domain.Post;
import com.groom.groom.repository.PostRepository;
import com.groom.groom.service.MatchingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "matching", description = "매칭")
@RestController
@RequiredArgsConstructor
@RequestMapping("/matching")
public class MatchingContorller {
    private final MatchingService matchingService;
    private final PostRepository postRepository;

    @PostMapping("/save/{post_idx}/{user_idx}")
    @Operation(summary = "matching/save/1/1", description = "매칭 신청")
    public ResponseEntity<Matching> save(@PathVariable int post_idx, @PathVariable int user_idx){
        Post post= postRepository.findById(post_idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+post_idx));
        if (post.getApplication() == post.getNumber()){
            post.complete();
            postRepository.save(post); // 변경 사항을 데이터베이스에 저장
            throw new IllegalStateException("모집 마감된 게시글입니다.");
        }
        post.increaseApplication();
        Matching matching = matchingService.saveMatching(post_idx, user_idx);
        return ResponseEntity.status(HttpStatus.CREATED).body(matching);
    }

}
