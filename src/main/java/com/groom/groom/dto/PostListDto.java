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
    @Schema(description = "메뉴", example = "갈치조림")
    private String menuname;
    @Schema(description = "날짜", example = "내일")
    private String date;
    @Schema(description = "시간", example = "아침")
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
    @Schema(description = "위도", example = "33.449967")
    private double lat;
    @Schema(description = "경도", example = "126.918558")
    private double lng;
    public PostListDto(@NotNull Post entity){
        this.menuname = entity.getMenu().getName();
        this.date=entity.getDate();
        this.time = entity.getTime();
        this.number= entity.getNumber();
        this.application=entity.getApplication();
        this.item=entity.getItem();
        this.address=entity.getAddress();
        this.status=entity.getStatus();
        this.lat=entity.getLat();
        this.lng=entity.getLng();
    }

}
