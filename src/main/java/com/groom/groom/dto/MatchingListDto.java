package com.groom.groom.dto;

import com.groom.groom.domain.MatchingStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class MatchingListDto {
    private String menuName;
    private String img;
    private String address;
    private int menuPrice;
    private int matchingIdx;
    private int postIdx;
    private char postStatus;
    private LocalDate postDate;


    public MatchingListDto(String menuName, String img, String address, int menuPrice, int matchingIdx, int postIdx, char postStatus, LocalDate postDate) {
        this.menuName = menuName;
        this.img=img;
        this.address = address;
        this.menuPrice = menuPrice;
        this.matchingIdx = matchingIdx;
        this.postIdx = postIdx;
        this.postStatus = postStatus;
        this.postDate = postDate;
    }
}
