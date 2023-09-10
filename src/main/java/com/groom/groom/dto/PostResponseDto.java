package com.groom.groom.dto;

import com.groom.groom.domain.Menu;
import com.groom.groom.domain.MenuItem;
import com.groom.groom.domain.Post;
import com.groom.groom.domain.Users;
import com.groom.groom.repository.PostRepository;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
public class PostResponseDto {

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
    @Schema(description = "세부 주소", example = "900동 000호")
    private String detailAdd;
    @Schema(description = "날짜", example = "아침")
    private String date;
    @Schema(description = "년도날짜", example = "2023-07-23")
    private LocalDate realdate;
    @Schema(description = "시간", example = "아침")
    private String time;
    @Schema(description = "주 재료", example = "갈치")
    private List<MenuItem> item;
    @Schema(description = "비용", example = "20000")
    private int money;
    @Schema(description = "상태", example = "C")
    private char status;

    public PostResponseDto(@NotNull Post entity){
        this.writer=entity.getUser().getId();
        this.great=entity.getUser().getGreat();
        this.good=entity.getUser().getGood();
        this.menuname = entity.getMenu().getName();
        this.menucontent=entity.getMenu().getContent();
        this.menuimg=entity.getMenu().getImg();
        this.date=entity.getDate();
        this.realdate=entity.getRealdate();
        this.time= entity.getTime();
        this.item=entity.getMenu().getItem();
        this.address=entity.getAddress();
        this.detailAdd=entity.getDetailAdd();
        this.status = entity.getStatus();
        this.money=entity.getMoney();
    }
}
