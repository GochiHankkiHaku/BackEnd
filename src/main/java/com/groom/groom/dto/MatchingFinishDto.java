package com.groom.groom.dto;

import com.groom.groom.domain.Matching;
import com.groom.groom.domain.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class MatchingFinishDto {
    // 제목, 주소, 날짜, 가격, 모집완료
    @Schema(description = "메뉴", example = "갈치조림")
    private String menu;

    @Schema(description = "도로명주소", example = "제주도 제주시~~~")
    private String address;

    //날짜


    @Schema(description = "비용", example = "20000")
    private int money;

    @Schema(description = "글 상태", example = "N")
    private char status;

    public MatchingFinishDto(@NotNull Matching entity){
        this.menu = entity.getPost().getMenu().getName();
        this.address=entity.getPost().getAddress();
        this.money=entity.getPost().getMoney();
        this.status=entity.getPost().getStatus();

    }

}
