package com.groom.groom.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class MenuItem {

    @Column(length = 50, nullable = false)
    private String ingredient; // 재료 이름

    @Column(nullable = false)
    private int price; // 가격

    @Builder
    public MenuItem(String ingredient, int price) {
        this.ingredient = ingredient;
        this.price = price;
    }
}
