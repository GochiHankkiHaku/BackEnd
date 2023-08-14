package com.groom.groom.controller;

import com.groom.groom.domain.Matching;

import com.groom.groom.domain.Post;
import com.groom.groom.repository.MatchingRepository;
import com.groom.groom.repository.PostRepository;
import com.groom.groom.service.MatchingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "matching", description = "매칭")
@RestController
@RequiredArgsConstructor
@RequestMapping("/matching")
public class MatchingContorller {
    private final MatchingService matchingService;
    private final PostRepository postRepository;
    private final MatchingRepository matchingRepository;

    @PostMapping("/save/{post_idx}/{user_idx}")
    @Operation(summary = "matching/save/1/1", description = "매칭 신청")
    public ResponseEntity<Matching> save(@PathVariable int post_idx, @PathVariable int user_idx){
        Post post= postRepository.findById(post_idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+post_idx));
        Matching matching = matchingService.saveMatching(post_idx, user_idx);
        return ResponseEntity.status(HttpStatus.CREATED).body(matching);

    }

    //매칭 신청자 리스트 확인
    @GetMapping("/{post_idx}/list")
    @Operation(summary = "/matching/1/list", description = "매칭 신청자 리스트 확인")
    public ResponseEntity<List<String>> getMatchRequestsByPost(@PathVariable int post_idx) {
        List<Matching> matchRequests = matchingService.getMatchRequestsByPost(post_idx);
        List<String> userIds = matchRequests.stream()
                .map(matching -> matching.getUser().getId())
                .collect(Collectors.toList());
        return ResponseEntity.ok(userIds);
    }
    //매칭 수락
    @PutMapping("/ok/{matching_idx}")
    @Operation(summary = "/matching/ok/1", description = "매칭 수락")
    public ResponseEntity<Void> okMatching(@PathVariable int matching_idx){
        matchingService.okMatch(matching_idx);
        return ResponseEntity.ok().build();
    }

    //매칭 거절
    @PutMapping("/no/{matching_idx}")
    @Operation(summary = "/matching/no/1", description = "매칭 수락")
    public ResponseEntity<Void> noMatching(@PathVariable int matching_idx){
        matchingService.noMatch(matching_idx);
        return ResponseEntity.ok().build();
    }
}
