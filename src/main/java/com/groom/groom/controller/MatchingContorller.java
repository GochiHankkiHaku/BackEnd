package com.groom.groom.controller;

import com.groom.groom.domain.Matching;

import com.groom.groom.domain.Post;
import com.groom.groom.dto.*;
import com.groom.groom.repository.MatchingRepository;
import com.groom.groom.repository.PostRepository;
import com.groom.groom.service.MatchingService;
import com.groom.groom.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private final PostService postService;

    @PostMapping("/save/{post_idx}/{user_idx}")
    @Operation(summary = "matching/save/1/1", description = "매칭 신청")
    public ResponseEntity<Matching> save(@PathVariable int post_idx, @PathVariable int user_idx, @RequestParam String contact){
        Post post= postRepository.findById(post_idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+post_idx));
        Matching matching = matchingService.saveMatching(post_idx, user_idx, contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(matching);

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


    //모임 히스토리 리스트
    @GetMapping("/list/{user_idx}")
    @Operation(summary = "/matching/list/1", description = "유저가 진행한 모든 매칭 리스트 반환")
    public ResponseEntity<List<MatchingListDto>> getMatchingsByUser(@PathVariable int user_idx) {
        List<MatchingListDto> matchingsByUserDto = new ArrayList<>();

        if (user_idx==1) {
            List<Post> postsByUser = postRepository.findByUserIdx(user_idx);

            for (Post post : postsByUser) {
                String address = post.getAddress() + post.getDetailAdd();
                MatchingListDto dto = new MatchingListDto(
                        post.getMenu().getName(),
                        post.getMenu().getImg(),
                        address,
                        post.getMenu().getTotalPrice(),
                        0,
                        post.getIdx(),
                        post.getStatus(),
                        post.getRealdate()
                );
                matchingsByUserDto.add(dto);
            }
        }
        else if(user_idx==2){
                List<Matching> matchingsByUser = matchingService.getMatchingsByUser(user_idx);
                for (Matching matching : matchingsByUser) {
                    String address = matching.getPost().getAddress() + matching.getPost().getDetailAdd();
                    MatchingListDto dto = new MatchingListDto(
                            matching.getPost().getMenu().getName(),
                            matching.getPost().getMenu().getImg(),
                            address,
                            matching.getPost().getMenu().getTotalPrice(),
                            matching.getId(),
                            matching.getPost().getIdx(),
                            matching.getPostStatus(),
                            matching.getPost().getRealdate()
                    );
                    matchingsByUserDto.add(dto);
                }
        }
        else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(matchingsByUserDto);
    }
    //모임 히스토리 개최자 디테일
    @GetMapping("/detail/{post_idx}")
    @Operation(summary = "/matching/detail/1", description = "유저가 진행한 모든 매칭 리스트 반환")
    public ResponseEntity<MatchingWriterDetailDto> getMatchingsByWriter(@PathVariable int post_idx) {
        Post post = postRepository.findById(post_idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다"));

        List<Matching> matchRequests = matchingService.getMatchRequestsByPost(post_idx);
        List<MatchingUserDto> matchingUsers = matchRequests.stream()
                .map(matching -> new MatchingUserDto(
                        matching.getUser().getId(),
                        matching.getId(),
                        matching.getContact()))
                .collect(Collectors.toList());
        MatchingWriterDetailDto responseDto = new MatchingWriterDetailDto(post, matchingUsers);
        return ResponseEntity.ok(responseDto);
    }


}
