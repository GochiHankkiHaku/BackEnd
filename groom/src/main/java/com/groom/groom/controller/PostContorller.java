package com.groom.groom.controller;

import com.groom.groom.domain.Post;
import com.groom.groom.dto.PostSaveDto;
import com.groom.groom.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "post", description = "매칭 게시글 작성")
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostContorller {
    private final PostService postService;

    @PostMapping("/write")
    @Operation(summary = "post/write", description = "매칭 게시글 작성")
    public ResponseEntity<Post> save(@RequestBody PostSaveDto requestDto){
        Post post = postService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);

    }
}
