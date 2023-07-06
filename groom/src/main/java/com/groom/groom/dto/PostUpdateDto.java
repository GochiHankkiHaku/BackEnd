package com.groom.groom.dto;


import com.groom.groom.domain.Menu;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostUpdateDto {
    private Menu menu;
    private String content;
    private String time;
    private int number;
    private List<String> item;
    private String category;

    @Builder
    public PostUpdateDto(Menu menu, String content, String time, int number,
                         List<String> item, String category){
        this.menu = menu;
        this. content=content;
        this.time=time;
        this.number=number;
        this.item=item;
        this.category=category;
    }
}
