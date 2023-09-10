package com.groom.groom.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class MatchingListDto {
    private String menuName;
    private String address;
    private int menuPrice;
    private int matchingIdx;
    private int postIdx;
    private char postStatus;
    private LocalDate postDate;

    public MatchingListDto(String menuName, String address, int menuPrice, int matchingIdx, int postIdx, char postStatus, LocalDate postDate) {
        this.menuName = menuName;
        this.address = address;
        this.menuPrice = menuPrice;
        this.matchingIdx = matchingIdx;
        this.postIdx = postIdx;
        this.postStatus = postStatus;
        this.postDate = postDate;
    }
}
