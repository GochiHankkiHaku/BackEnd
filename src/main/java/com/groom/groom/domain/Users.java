package com.groom.groom.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
@Setter
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(nullable = false, length = 15)
    @Schema(description = "아이디", example = "abc")
    private String id;


    @Column(nullable = false, columnDefinition = "integer default 0")
    @Schema(description = "최고에요", example = "1")
    private int great;

    @Column(nullable = false, columnDefinition = "integer default 0")
    @Schema(description = "좋아요", example = "1")
    private int good;


    @Column(nullable = false, columnDefinition = "integer default 0")
    @Schema(description = "별로에요", example = "1")
    private int notgood;

    @Builder
    public Users(String id){
        this.id=id;
    }
}
