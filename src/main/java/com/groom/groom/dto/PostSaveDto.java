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
    @Schema(description = "시간", example = "아침")
    private String time;
    @Schema(description = "인원", example = "1")
    private int number;
    @Schema(description = "위도", example = "33.449701")
    private double lat;
    @Schema(description = "경도", example = "126.917109")
    private double lng;
    @Schema(description = "도로명주소", example = "제주도 제주시~~~")
    private String address;
    @Schema(description = "상태", example = "N")
    private char status;
    @Schema(description = "비용", example = "20000")
    private int money;
    @Schema(description = "사진", example = "https://~~")
    private String img;
    public Post toEntity(){
        return Post.builder()
                .user(user)
                .date(date)
                .time(time)
                .number(number)
                .lat(lat)
                .lng(lng)
                .status(status)
                .status('N')
                .money(money)
                .img(img)
                .build();
    }
    public void setUser(Users user) {this.user = user;}
    public void setImg(String url) {this.img = url;}


}
