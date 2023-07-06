package com.groom.groom.dto;


import com.groom.groom.domain.Menu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostUpdateDto {
    private String menuname;
    private String content;
    private String time;
    private int number;
    private List<String> item;
    private String category;
    private float lat;
    private float lng;
    private String address;

    @Builder
    public PostUpdateDto(String menuname, String content, String time, int number,
                         List<String> item, String category, float lat, float lng,
                         String address){
        this.menuname = menuname;
        this. content=content;
        this.time=time;
        this.number=number;
        this.item=item;
        this.category=category;
        this.lat=lat;
        this.lng=lng;
        this.address=address;
    }
}
