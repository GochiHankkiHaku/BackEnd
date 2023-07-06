package com.groom.groom.controller;

import com.groom.groom.domain.Users;
import com.groom.groom.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "users", description = "유저")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;
    @PostMapping("/signup")
    @Operation(summary = "users/signup", description = "회원가입")
    public String save(@RequestBody String id){
        Users user = usersService.saveUsers(id);
        return user.getId();
    }
}
