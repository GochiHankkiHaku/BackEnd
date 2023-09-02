package com.groom.groom.domain;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class MenuItem {

    @Column(nullable = false)
    private int idx;

    @Column(length = 50, nullable = false)
    private String ingredient; // 재료 이름

    @Column(nullable = false)
    private int price; // 가격

    @Column(length = 500)
    private String url; // 재료 이름

    @Builder
    public MenuItem(int idx, String ingredient, int price, String url) {
        this.idx = idx;
        this.ingredient = ingredient;
        this.price = price;
        this.url = url;
    }
}
