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
    private String date;
    private String time;
    private int number;
    private List<String> item;
    private double lat;
    private double lng;
    private String address;

    @Builder
    public PostUpdateDto(String menuname, String date, String time, int number,
                         List<String> item, double lat, double lng,
                         String address){
        this.menuname = menuname;
        this.date=date;
        this.time=time;
        this.number=number;
        this.item=item;
        this.lat=lat;
        this.lng=lng;
        this.address=address;
    }
}
