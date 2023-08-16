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
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Column(nullable = true)
    @Schema(description = "년도날짜", example = "2023-07-23" )
    private LocalDate realdate;

    @Column(length = 50, nullable = false)
    @Schema(description = "날짜", example = "오늘")
    private String date;

    @Column(length = 50, nullable = false)
    @Schema(description = "시간", example = "오전")
    private String time;

    @Column(nullable = false)
    @Schema(description = "인원", example = "1")
    private int min;

    @Column(nullable = false)
    @Schema(description = "인원", example = "1")
    private int max;

    @Column(nullable = false)
    @Schema(description = "위도", example = "33.449701")
    private double lat;

    @Column(nullable = false)
    @Schema(description = "경도", example = "126.917109")
    private double lng;

    @Column(nullable = false)
    @Schema(description = "비용", example = "20000")
    private int money;

    @Column(nullable = false)
    @Schema(description = "글 상태", example = "N")
    private char status;

    @Column(nullable = false)
    @Schema(description = "글 이미지", example = "https://~~~")
    private String img;


    @Column(nullable = false)
    @Schema(description = "연락수단", example = "전화번호/카카오톡id/옾챗")
    private String contact;

    @Column(nullable = false)
    @Schema(description = "주소", example = "제주도 서귀포시 ~~")
    private String address;

    @Column(nullable = false)
    @Schema(description = "상세주소", example = "900동 000호")
    private String detailAdd;


    @Builder
    public Post(Users user, Menu menu, String date, String time, int min, int max,
                double lat, double lng, int money, char status, String img, String contact,
                String address, String detailAdd){
        this.menu=menu;
        this.user=user;
        this.date=date;
        this.time=time;
        this.min=min;
        this.max=max;
        this.lat=lat;
        this.lng=lng;
        this.money=money;
        this.status=status;
        this.img=img;
        this.contact=contact;
        this.address=address;
        this.detailAdd=detailAdd;
    }

    public void update(Menu menu, String date, String time, int min, int max,
                       double lat, double lng, int money, String img, String contact,
                       String address, String detailAdd
    ){
        this.menu=menu;
        this.date = date;
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
    public void delete(){
        this.status = 'D';
    }

    public void complete(){
        this.status = 'C';
    }

}
