package com.groom.groom.controller;

import com.groom.groom.domain.Users;
import com.groom.groom.repository.UsersRepository;
import com.groom.groom.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "users", description = "유저")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;
    private final UsersRepository usersRepository;

    @PostMapping("/signup")
    @Operation(summary = "users/signup", description = "회원가입")
    public String save(@RequestBody String id){
        Users user = usersService.saveUsers(id);
        return user.getId();
    }

    @PutMapping("/review/{user_idx}")
    @Operation(summary = "review/1", description = "리뷰 작성")
    public Users review(@PathVariable int user_idx, @RequestParam String reviewType){
        Users user = usersRepository.findById(user_idx)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        switch (reviewType) {
            case "great":
                user.setGreat(user.getGreat() + 1);
                break;
            case "good":
                user.setGood(user.getGood() + 1);
                break;
            case "notgood":
                user.setNotgood(user.getNotgood() + 1);
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 리뷰 타입입니다.");
        }
        usersRepository.save(user);
        return user;
    }
}
