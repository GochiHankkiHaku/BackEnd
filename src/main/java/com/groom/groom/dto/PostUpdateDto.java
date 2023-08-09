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
    private int min;
    private int max;
    private double lat;
    private double lng;
    private int money;
    private String img;
    private String contact;
    private String address;
    private String detailAdd;

    @Builder
    public PostUpdateDto(String menuname, String date, String time, int min, int max,
                         double lat, double lng, int money, String img, String contact,
                         String address, String detailAdd){
        this.menuname = menuname;
        this.date=date;
        this.time=time;
        this.min=min;
        this.max=max;
        this.lat=lat;
        this.lng=lng;
        this.money=money;
        this.img=img;
        this.contact=contact;
        this.address=address;
        this.detailAdd=detailAdd;
    }
}
