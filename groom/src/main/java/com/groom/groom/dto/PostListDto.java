package com.groom.groom.dto;

import com.groom.groom.domain.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
public class PostListDto {
    @Schema(description = "본문", example = "본문내용")
    private String content;
    @Schema(description = "시간", example = "내일 오전")
    private String time;
    @Schema(description = "인원", example = "3")
    private int number;
    @Schema(description = "신청인원", example = "2")
    private int application;
    @Schema(description = "필요 재료", example = "[\"고기\", \"생선\"]")
    private List<String> item;
    @Schema(description = "도로명주소", example = "제주도 제주시~~~")
    private String address;
    @Schema(description = "상태", example = "C")
    private char status;

    public PostListDto(@NotNull Post entity){
        this.content = entity.getContent();
        this.time = entity.getTime();
        this.number= entity.getNumber();
        this.application=entity.getApplication();
        this.item=entity.getItem();
        this.address=entity.getAddress();
        this.status=entity.getStatus();
    }

}
