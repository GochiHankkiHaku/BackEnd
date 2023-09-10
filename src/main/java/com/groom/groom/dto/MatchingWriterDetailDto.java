package com.groom.groom.dto;

import com.groom.groom.domain.MenuItem;
import com.groom.groom.domain.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@NoArgsConstructor
public class MatchingWriterDetailDto {

    @Schema(description = "메뉴", example = "갈치조림")
    private String menuname;
    @Schema(description = "메뉴설명", example = "갈치조림은 고추장에~~")
    private String menucontent;
    @Schema(description = "메뉴 이미지", example = "https://img~~~")
    private String menuimg;
    @Schema(description = "작성자", example = "a")
    private String writer;
    @Schema(description = "최고에요", example = "10")
    private int great;
    @Schema(description = "좋아요", example = "4")
    private int good;
    @Schema(description = "도로명주소", example = "제주도 제주시~~~")
    private String address;

    @Schema(description = "주 재료", example = "갈치")
    private List<MenuItem> item;
    @Schema(description = "매칭 신청자 리스트", example = "신청한 사람들")
    private List<MatchingUserDto> matchingUsers;

    public MatchingWriterDetailDto(@NotNull Post entity, List<MatchingUserDto> matchingUsers) {
        this.menuname = entity.getMenu().getName();
        this.menucontent = entity.getMenu().getContent();
        this.menuimg = entity.getMenu().getImg();
        this.writer = entity.getUser().getId();
        this.great = entity.getUser().getGreat();
        this.good = entity.getUser().getGood();
        this.address = entity.getAddress();
        this.item = entity.getMenu().getItem();
        this.matchingUsers=matchingUsers;
    }


}
