package com.groom.groom.dto;
import com.groom.groom.domain.Post;
import com.groom.groom.domain.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@Getter
public class PostSaveDto {
    @Schema(description = "유저", example = "a")
    private Users user;
    @Schema(description = "본문", example = "본문내용")
    private String content;
    @Schema(description = "시간", example = "내일 오전")
    private String time;
    @Schema(description = "인원", example = "1")
    private int number;


    public Post toEntity(){
        return Post.builder()
                .user(user)
                .content(content)
                .time(time)
                .number(number)
                .build();
    }
    public void setUser(Users user) {this.user = user;}
}
