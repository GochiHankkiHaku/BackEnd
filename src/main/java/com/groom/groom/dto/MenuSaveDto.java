package com.groom.groom.dto;

import com.groom.groom.domain.Menu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter

public class MenuSaveDto {
    @Schema(description = "이름", example = "갈치조림")
    private String name;
    @Schema(description = "내용", example = "갈치를 고추장에 조려서~~")
    private String content;
    @Schema(description = "재료 이름", example = "[\"고기\", \"생선\"]")
    private List<String> item;
    @Builder
    public MenuSaveDto(String name, String content, List<String> item){
        this.name = name;
        this.content = content;
        this.item=item;
    }

    public Menu toEntity(){
        return Menu.builder()
                .name(name)
                .content(content)
                .item(item)
                .build();
    }
}
