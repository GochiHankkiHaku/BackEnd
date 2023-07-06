package com.groom.groom.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.groom.groom.BaseTimeEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DynamicInsert
@Table(name = "post")
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    @JsonIgnore
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_idx")
    @JsonIgnore
    private Menu menu;

    @Column(length = 50, nullable = false)
    @Schema(description = "날짜", example = "오늘")
    private String date;

    @Column(length = 50, nullable = false)
    @Schema(description = "시간", example = "오전")
    private String time;

    @Column(nullable = false)
    @Schema(description = "인원", example = "1")
    private int number;

    @Column(nullable = false, columnDefinition = "integer default 0")
    @Schema(description = "신청인원", example = "1")
    private int application;

    @Column(nullable = false)
    @Schema(description = "위도", example = "33.449701")
    private double lat;

    @Column(nullable = false)
    @Schema(description = "경도", example = "126.917109")
    private double lng;

    @Column(length = 50, nullable = true)
    @Schema(description = "도로명주소", example = "제주도 제주시~~~")
    private String address;

    @Column(nullable = false)
    @Schema(description = "비용", example = "20000")
    private int money;

    @Column(nullable = false)
    @Schema(description = "글 상태", example = "N")
    private char status;
    @Builder
    public Post(Users user, Menu menu, String date, String time, int number, int application,
                double lat, double lng, String address,
                int money, char status){
        this.menu=menu;
        this.user=user;
        this.date=date;
        this.time=time;
        this.number=number;
        this.application =application;
        this.lat=lat;
        this.lng=lng;
        this.address=address;
        this.money=money;
        this.status=status;
    }

    public void update(Menu menu, String date, String time, int number){
        this.menu=menu;
        this.date = date;
        this.time=time;
        this.number=number;
    }
    public void delete(){
        this.status = 'D';
    }

    public void complete(){
        this.status = 'C';
    }
    public void increaseApplication(){
        this.application++;
    }

}
