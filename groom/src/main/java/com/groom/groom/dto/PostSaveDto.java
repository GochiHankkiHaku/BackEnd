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
    @Schema(description = "본문", example = "본문내용")
    private String content;
    @Schema(description = "시간", example = "내일 오전")
    private String time;
    @Schema(description = "인원", example = "1")
    private int number;
    @Schema(description = "주 재료", example = "갈치")
    private List<String> item;
    @Schema(description = "분류", example = "어패류")
    private String category;
    @Schema(description = "위도", example = "33.449701")
    private float lat;
    @Schema(description = "경도", example = "126.917109")
    private float lng;
    @Schema(description = "도로명주소", example = "제주도 제주시~~~")
    private String address;

    @Schema(description = "상태", example = "N")
    private char status;

    public Post toEntity(){
        return Post.builder()
                .user(user)
                .content(content)
                .time(time)
                .number(number)
                .item(item)
                .lat(lat)
                .lng(lng)
                .status(status)
                .status('N')
                .build();
    }
    public void setUser(Users user) {this.user = user;}


}
