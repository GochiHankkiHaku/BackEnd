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
    @CollectionTable(name = "post_item", joinColumns = @JoinColumn(name = "post_idx"))
    @Column(name = "item", length = 50) // 컬럼 길이 설정
    @Schema(description = "재료 이름", example = "[\"고기\", \"생선\"]")
    private List<String> item;


    //이미지도 시간 남으면?

    @Builder
    public Menu(String name, String content, List<String> item){
        this.name=name;
        this.content=content;
        this.item=item;
    }

}
