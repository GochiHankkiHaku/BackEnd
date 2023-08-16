package com.groom.groom.domain;

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
@Table(name = "menu")

public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(length = 50)
    @Schema(description = "이름", example = "갈치조림")
    private String name;

    @Column(length = 100, nullable = false)
    @Schema(description = "내용", example = "갈치를 고추장에 조려서~~")
    private String content;

    @ElementCollection
    @CollectionTable(name = "menu_item", joinColumns = @JoinColumn(name = "menu_idx"))
    @Schema(description = "재료 목록", example = "[{\"ingredient\": \"고기\", \"price\": 3000}, {\"ingredient\": \"생선\", \"price\": 2000}]")
    private List<MenuItem> item;


    @Column(length = 500)
    @Schema(description = "이미지", example = "https://")
    private String img;

    @Column(nullable = false,columnDefinition = "integer default 0")
    @Schema(description = "메뉴 선택한 사람 명", example = "1")
    private int choose;

    @Builder
    public Menu(String name, String content, List<MenuItem> item, String img, int choose){
        this.name=name;
        this.content=content;
        this.item=item;
        this.img=img;
        this.choose=choose;
    }

    public void chooseUp(){
        this.choose +=1;
    }


}
