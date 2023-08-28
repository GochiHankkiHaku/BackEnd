package com.groom.groom.dto;

import com.groom.groom.domain.Menu;
import com.groom.groom.domain.MenuItem;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
public class MenuListDto {

    @Schema(description = "이름", example = "갈치조림")
    private String name;
    @Schema(description = "설명", example = "갈치를 고추장에 조려서~~")
    private String content;
    @Schema(description = "재료 목록", example = "[{\"ingredient\": \"고기\", \"price\": 3000}, {\"ingredient\": \"생선\", \"price\": 2000}]")
    private List<MenuItem> item;
    @Schema(description = "평균 가격", example = "20000")
    private int total;


    public MenuListDto(@NotNull Menu entity){
        this.name=entity.getName();
        this.content=entity.getContent();
        this.item=entity.getItem();
        this.total=entity.getTotalPrice();

    }



}
