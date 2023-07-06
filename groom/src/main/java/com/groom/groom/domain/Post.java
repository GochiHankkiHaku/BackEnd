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
    private Menu menu;

    @Column(length = 200)
    @Schema(description = "본문", example = "본문내용")
    private String content;

    @Column(length = 50, nullable = false)
    @Schema(description = "시간", example = "내일 오전")
    private String time;

    @Column(nullable = false)
    @Schema(description = "안원", example = "1")
    private int number;

    @Column(nullable = false, columnDefinition = "integer default 0")
    @Schema(description = "신청인원", example = "1")
    private int application;

    @Column(name = "item")
    @ElementCollection
    @CollectionTable(name = "post_item", joinColumns = @JoinColumn(name = "post_idx"))
    @Schema(description = "아이템 리스트", example = "[\"고기\", \"생선\"]")
    private List<String> item;

    //nullable = false 추가하고 분류 정해지면 추가
    @Column(length = 100)
    @Schema(description = "분류", example = "어패류")
    private String category;
    @Column(nullable = false)
    @Schema(description = "위도", example = "33.449701")
    private float lat;

    @Column(nullable = false)
    @Schema(description = "경도", example = "126.917109")
    private float lng;

    @Column(length = 50, nullable = true)
    @Schema(description = "도로명주소", example = "제주도 제주시~~~")
    private String address;


    @Column(nullable = false)
    @Schema(description = "글 상태", example = "N")
    private char status;
    @Builder
    public Post(Users user, Menu menu, String content, String time, int number, List<String> item, String category, float lat, float lng, char status){
        this.menu=menu;
        this.user=user;
        this.content=content;
        this.time=time;
        this.number=number;
        this.item=item;
        this.category=category;
        this.lat=lat;
        this.lng=lng;
        this.status=status;
    }

    public void update(Menu menu, String content, String time, int number, List<String> item, String category){
        this.menu=menu;
        this.content=content;
        this.time=time;
        this.number=number;
        this.item=item;
        this.category=category;
    }
    public void delete(){
        this.status = 'D';
    }

    public void complete(){
        this.status = 'C';
    }

    //public void setCategory() {} -> 카테고리 설정
}
