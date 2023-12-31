package com.groom.groom.dto;

import com.groom.groom.domain.Menu;
import com.groom.groom.domain.Post;
import com.groom.groom.domain.Users;
import com.groom.groom.repository.PostRepository;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
public class PostResponseDto {
    @Schema(description = "메뉴", example = "갈치조림")
    private String menuname;
    @Schema(description = "메뉴설명", example = "갈치조림은 고추장에~~")
    private String menucontent;
    @Schema(description = "날짜", example = "아침")
    private String date;
    @Schema(description = "시간", example = "아침")
    private String time;
    @Schema(description = "인원", example = "2")
    private int number;
    @Schema(description = "신청인원", example = "1")
    private int application;
    @Schema(description = "주 재료", example = "갈치")
    private List<String> item;
    @Schema(description = "도로명주소", example = "제주도 제주시~~~")
    private String address;
    @Schema(description = "비용", example = "20000")
    private int money;
    @Schema(description = "상태", example = "C")
    private char status;
    @Schema(description = "이미지", example = "https:///~~~")
    private String img;
    public PostResponseDto(@NotNull Post entity){
        this.menuname = entity.getMenu().getName();
        this.menucontent=entity.getMenu().getContent();
        this.date=entity.getDate();
        this.time= entity.getTime();


        this.item=entity.getMenu().getItem();
        this.address=entity.getAddress();
        this.status = entity.getStatus();
        this.money=entity.getMoney();
        this.img=entity.getImg();
    }


}
