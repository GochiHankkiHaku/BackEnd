package com.groom.groom.dto;
import com.groom.groom.domain.Menu;
import com.groom.groom.domain.Post;
import com.groom.groom.domain.Users;
import com.groom.groom.repository.MenuRepository;
import com.groom.groom.repository.PostRepository;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@NoArgsConstructor
@Getter
public class PostSaveDto {
    private MenuRepository menuRepository;

    @Schema(description = "유저", example = "a")
    private Users user;
    @Schema(description = "메뉴 이름", example = "갈치조림")
    private String menuname;
    @Schema(description = "날짜", example = "오늘")
    private String date;
    @Schema(description = "년도날짜", example = "2023-07-23")
    private LocalDate realdate;
    @Schema(description = "시간", example = "아침")
    private String time;
    @Schema(description = "인원", example = "1")
    private int min;
    @Schema(description = "인원", example = "1")
    private int max;
    @Schema(description = "위도", example = "33.449701")
    private double lat;
    @Schema(description = "경도", example = "126.917109")
    private double lng;
    @Schema(description = "주소", example = "제주도 서귀포시 ~~")
    private String address;
    @Schema(description = "상세주소", example = "900동 000호")
    private String detailAdd;
    @Schema(description = "상태", example = "N")
    private char status;
    @Schema(description = "비용", example = "20000")
    private int money;
    @Schema(description = "연락수단", example = "전화번호/카카오톡id/옾챗")
    private String contact;
    public Post toEntity(){
        if ("오늘".equals(date)) {
            realdate = LocalDate.now();
        } else if ("내일".equals(date)) {
            realdate = LocalDate.now().plus(1, ChronoUnit.DAYS);
        }
        return Post.builder()
                .user(user)
                .date(date)
                .realdate(realdate)  // 추가된 부분
                .time(time)
                .min(min)
                .max(max)
                .lat(lat)
                .lng(lng)
                .address(address)
                .detailAdd(detailAdd)
                .status('N')
                .money(money)
                .contact(contact)
                .build();
    }
    public void setUser(Users user) {this.user = user;}


}
