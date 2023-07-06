package com.groom.groom.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DynamicInsert
@Table(name = "market")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    @Schema(description = "시장 이름", example = "고성오일시장")
    private String store;
    @Schema(description = "위도", example = "33.452158")
    private double lat;
    @Schema(description = "경도", example = "126.913904")
    private double lng;

    @Builder
    public Market(String store, double lat, double lng){
        this.store=store;
        this.lat=lat;
        this.lng=lng;

    }
}
