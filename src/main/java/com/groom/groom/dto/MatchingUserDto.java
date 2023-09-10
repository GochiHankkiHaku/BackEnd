package com.groom.groom.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MatchingUserDto {

    @Schema(description = "유저 이름", example = "user123")
    private String username;

    @Schema(description = "매칭 인덱스", example = "1")
    private int matchingIndex;

    @Schema(description = "연락 수단", example = "user@example.com")
    private String contactMethod;

    public MatchingUserDto(String username, int matchingIndex, String contactMethod) {
        this.username = username;
        this.matchingIndex = matchingIndex;
        this.contactMethod = contactMethod;
    }
}
