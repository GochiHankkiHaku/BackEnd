package com.groom.groom.dto;

import com.groom.groom.domain.Menu;
import com.groom.groom.domain.MenuItem;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter

public class MenuSaveDto {
    @Schema(description = "이름", example = "갈치조림")
    private String name;
    @Schema(description = "내용", example = "갈치를 고추장에 조려서~~")
    private String content;
    @Schema(description = "재료 목록", example = "[{\"ingredient\": \"고기\", \"price\": 3000}, {\"ingredient\": \"생선\", \"price\": 2000}]")
    private List<MenuItem> item;
    @Builder
    public MenuSaveDto(String name, String content, List<MenuItem> item){
        this.name = name;
        this.content = content;
        this.item=item;
    }

    public Menu toEntity(){
        List<MenuItem> menuItems = new ArrayList<>();
        for (MenuItem menuItemDto : item) {
            menuItems.add(new MenuItem(menuItemDto.getIngredient(), menuItemDto.getPrice()));
        }
        return Menu.builder()
                .name(name)
                .content(content)
                .item(item)
                .item(menuItems)
                .build();
    }
}
