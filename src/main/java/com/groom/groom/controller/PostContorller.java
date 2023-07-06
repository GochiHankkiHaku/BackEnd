package com.groom.groom.controller;

import com.groom.groom.domain.Post;
import com.groom.groom.dto.PostListDto;
import com.groom.groom.dto.PostResponseDto;
import com.groom.groom.dto.PostSaveDto;
import com.groom.groom.dto.PostUpdateDto;
import com.groom.groom.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "post", description = "매칭 게시글 작성")
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostContorller {
    private final PostService postService;
    private final MarketService marketService;

    @PostMapping("/write")
    @Operation(summary = "post/write", description = "매칭 게시글 작성")
    public ResponseEntity<Post> save(@RequestBody PostSaveDto requestDto){
        Post post = postService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    //시장 보기
    @GetMapping("/listmarket")
    @Operation(summary = "post/listmarket", description = "게시글 시장")
    public ResponseEntity<List<Market>> findAllMarket() {
        List<Market> marketList = marketService.getAllMarkets();
        return ResponseEntity.status(HttpStatus.OK).body(marketList);
    }
    //게시글 전체보기
    @GetMapping("/listall")
    @Operation(summary = "post/listall", description = "게시글 전체보기, 기본 최신순")
    public ResponseEntity<List<PostListDto>> findAllPosts(){
        char flag = 'D';
        List<PostListDto> list = postService.findByPost_notstatus(flag);
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/nearby")
    @Operation(summary = "post/nearby", description = "사용자 주변 1km 게시글")
    public ResponseEntity<List<PostListDto>> getNearbyPosts(@RequestParam("lat") float userLat, @RequestParam("lng") float userLng) {
        List<Post> nearbyPosts = postService.findPostsNearby(userLat, userLng);
        List<PostListDto> nearbyPostsDto = nearbyPosts.stream()
                .map(PostListDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(nearbyPostsDto);
    }



    @GetMapping("/{post_idx}")
    @Operation(summary = "post/{idx}", description = "매칭 글 상세")
    public ResponseEntity<PostResponseDto> findById(@PathVariable int post_idx){
        PostResponseDto dto = postService.findById(post_idx);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }

    @PutMapping("/{post_idx}")
    @Operation(summary = "post/{post_idx}",description = "매칭 글 수정")
    public ResponseEntity<Post> update(@PathVariable int post_idx, @RequestBody PostUpdateDto requestDto){
        Post post = postService.update(post_idx, requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @DeleteMapping("/{post_idx}")
    @Operation(summary = "post/{post_idx}", description = "매칭 글 삭제")
    public ResponseEntity<Void> delete(@PathVariable int post_idx){
        postService.delete(post_idx);
        return ResponseEntity.ok().build();

    }


}
