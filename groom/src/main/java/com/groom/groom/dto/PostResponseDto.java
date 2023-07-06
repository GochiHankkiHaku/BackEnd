package com.groom.groom.dto;

import com.groom.groom.domain.Menu;
import com.groom.groom.domain.Post;
import com.groom.groom.domain.Users;
import com.groom.groom.repository.PostRepository;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class PostResponseDto {
    @Schema(description = "유저", example = "a")
    private Users user;

    @Schema(description = "메뉴", example = "갈치조림")
    private Menu menu;

    @Schema(description = "본문", example = "본문내용")
    private String content;
    @Schema(description = "시간", example = "내일 오전")
    private String time;
    @Schema(description = "인원", example = "1")
    private int number;

    public PostResponseDto(@NotNull Post entity){
        this.user = entity.getUser();
        this.menu = entity.getMenu();
        this.content = entity.getContent();
        this.time= entity.getTime();
        this.number=entity.getNumber();
    }

}
