package com.groom.groom.controller;

import com.groom.groom.domain.Menu;
import com.groom.groom.domain.MenuItem;
import com.groom.groom.domain.Post;
import com.groom.groom.domain.Users;
import com.groom.groom.repository.MenuRepository;
import com.groom.groom.repository.PostRepository;
import com.groom.groom.repository.UsersRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "setup", description = "처음 정보 입력")
@RequestMapping("/setup")
@RestController
@RequiredArgsConstructor

public class SetupContorller {
    private final UsersRepository usersRepository;
    private final MenuRepository menuRepository;
    private final PostRepository postRepository;

    @GetMapping("/")
    public String setup() {
        // Define initial users
        Users user1 = new Users("양경택");
        Users user2 = new Users("최지원" );
        usersRepository.save(user1);
        usersRepository.save(user2);


        List<MenuItem> item1 = new ArrayList<>();

        item1.add(MenuItem.builder().idx(0).ingredient("성게").price(15000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A5%E1%84%85%E1%85%B2.png").build());
        item1.add(MenuItem.builder().idx(1).ingredient("고사리").price(5000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item1.add(MenuItem.builder().idx(2).ingredient("대추").price(2000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%80%E1%85%AA%E1%84%8B%E1%85%B5%E1%86%AF.png").build());
        item1.add(MenuItem.builder().idx(3).ingredient("마늘").price(2000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());

        List<MenuItem> item2 = new ArrayList<>();
        item2.add(MenuItem.builder().idx(0).ingredient("자리돔").price(12000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A5%E1%84%85%E1%85%B2.png").build());
        item2.add(MenuItem.builder().idx(1).ingredient("쪽파").price(3500).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item2.add(MenuItem.builder().idx(2).ingredient("무").price(3000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item2.add(MenuItem.builder().idx(3).ingredient("다진마늘").price(3450).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item2.add(MenuItem.builder().idx(4).ingredient("흰쌀밥").price(3500).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%80%E1%85%A9%E1%86%A8%E1%84%85%E1%85%B2.png").build());


        List<MenuItem> item3 = new ArrayList<>();
        item3.add(MenuItem.builder().idx(0).ingredient("한치").price(17000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item3.add(MenuItem.builder().idx(1).ingredient("상추").price(5420).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item3.add(MenuItem.builder().idx(2).ingredient("오이").price(1290).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item3.add(MenuItem.builder().idx(3).ingredient("미나리").price(3230).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item3.add(MenuItem.builder().idx(4).ingredient("고추").price(2640).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item3.add(MenuItem.builder().idx(5).ingredient("메밀가루").price(1290).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%80%E1%85%A9%E1%86%A8%E1%84%85%E1%85%B2.png").build());

        List<MenuItem> item4 = new ArrayList<>();
        item4.add(MenuItem.builder().idx(0).ingredient("갈치").price(17000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item4.add(MenuItem.builder().idx(1).ingredient("배추").price(3520).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item4.add(MenuItem.builder().idx(2).ingredient("단호박").price(5000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());

        List<MenuItem> item5 = new ArrayList<>();
        item5.add(MenuItem.builder().idx(0).ingredient("삼겹살").price(13000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%80%E1%85%A9%E1%84%80%E1%85%B5.png").build());
        item5.add(MenuItem.builder().idx(1).ingredient("다시마").price(2450).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item5.add(MenuItem.builder().idx(2).ingredient("쪽파").price(3500).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item5.add(MenuItem.builder().idx(3).ingredient("소면").price(5000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%80%E1%85%A9%E1%86%A8%E1%84%85%E1%85%B2.png").build());

        List<MenuItem> item6 = new ArrayList<>();
        item6.add(MenuItem.builder().idx(0).ingredient("돼지등뼈").price(9630).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%80%E1%85%A9%E1%84%80%E1%85%B5.png").build());
        item6.add(MenuItem.builder().idx(1).ingredient("몸(모자반)").price(8950).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item6.add(MenuItem.builder().idx(2).ingredient("청양고추").price(2500).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item6.add(MenuItem.builder().idx(3).ingredient("다진마늘").price(3450).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item6.add(MenuItem.builder().idx(4).ingredient("흰쌀밥").price(3500).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%80%E1%85%A9%E1%86%A8%E1%84%85%E1%85%B2.png").build());


        List<MenuItem> item7 = new ArrayList<>();
        item7.add(MenuItem.builder().idx(1).ingredient("무").price(4890).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item7.add(MenuItem.builder().idx(2).ingredient("쪽파").price(2790).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item7.add(MenuItem.builder().idx(3).ingredient("메밀가루").price(9500).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%80%E1%85%A9%E1%86%A8%E1%84%85%E1%85%B2.png").build());


        List<MenuItem> item8 = new ArrayList<>();
        item3.add(MenuItem.builder().idx(0).ingredient("바지락").price(10000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item3.add(MenuItem.builder().idx(1).ingredient("새우").price(5000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item8.add(MenuItem.builder().idx(2).ingredient("미역").price(3000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item8.add(MenuItem.builder().idx(3).ingredient("쪽파").price(2790).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());
        item8.add(MenuItem.builder().idx(4).ingredient("마늘").price(2090).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/f_%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2.png").build());




        Menu menu1 = new Menu("구살국(성게국)", "옛 제주에서 귀한 손님을 위해 대접한 음식", item1, "https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png",0);
        Menu menu2 = new Menu("자리돔조림", "제주 연안에서 서식하는 자리돔을 간장으로 조린 음식", item2, "https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/%E1%84%8C%E1%85%A1%E1%84%85%E1%85%B5%E1%84%83%E1%85%A9%E1%86%B7%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.png",0);
        Menu menu3 = new Menu("한치 물회 덮밥", "싱싱한 오징어와 된장, 식초를 곁들인 물회", item3, "https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/%E1%84%92%E1%85%A1%E1%86%AB%E1%84%8E%E1%85%B5%20%E1%84%86%E1%85%AE%E1%86%AF%E1%84%92%E1%85%AC%20%E1%84%83%E1%85%A5%E1%87%81%E1%84%87%E1%85%A1%E1%86%B8.png",0);
        Menu menu4 = new Menu("갈치국", "토막 친 갈치에 배추, 호박의 채소와 양넘을 넣고 끓인 맑은 국", item3, "https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/%E1%84%80%E1%85%A1%E1%86%AF%E1%84%8E%E1%85%B5%E1%84%80%E1%85%AE%E1%86%A8.png",0);
        Menu menu5 = new Menu("고기국수", "돼지고기 수육이 올라간 제주도 특유의 국수 요리", item3, "https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/%E1%84%80%E1%85%A9%E1%84%80%E1%85%B5%E1%84%80%E1%85%AE%E1%86%A8%E1%84%89%E1%85%AE.png",0);
        Menu menu6 = new Menu("몸국", "돼지고기를 삶으면서 생긴 국물에 모자반을 넣고 끓인 국", item3, "https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/%E1%84%86%E1%85%A9%E1%86%B7%E1%84%80%E1%85%AE%E1%86%A8.png",0);
        Menu menu7 = new Menu("빙떡", "메밀가루를 반죽하여 돼지비계로 지진 전에 무채를 넣고 말아 만든 떡", item3, "https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/%E1%84%87%E1%85%B5%E1%86%BC%E1%84%84%E1%85%A5%E1%86%A8.png",0);
        Menu menu8 = new Menu("바릇국", "바다에서 채집할 수 있는 재료를 뚝배기에 담아낸 제주 향토 음식", item3, "https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/%E1%84%92%E1%85%A2%E1%84%86%E1%85%AE%E1%86%AF%E1%84%84%E1%85%AE%E1%86%A8%E1%84%87%E1%85%A2%E1%84%80%E1%85%B5.png",0);


        menuRepository.save(menu1);
        menuRepository.save(menu2);
        menuRepository.save(menu3);
        menuRepository.save(menu4);
        menuRepository.save(menu5);
        menuRepository.save(menu6);
        menuRepository.save(menu7);
        menuRepository.save(menu8);



        Post post1 = Post.builder()
                .user(user1)
                .menu(menu1)
                .date("오늘")
                .realdate(LocalDate.of(2023, 10, 2))
                .time("아침 (8:00 ~ 10:00)")
                .min(1)
                .max(3)
                .lat(37.505385)
                .lng(126.942561)
                .address("제주특별자치도 서귀포시 성산읍 동류암로 20")
                .detailAdd("12-55")
                .status('N')
                .contact("010-1234-1234")
                .money(20000)
                .build();



        Post post2 = Post.builder()
                .user(user1)
                .menu(menu2)
                .date("오늘")
                .realdate(LocalDate.of(2023, 9, 30))
                .time("점심 (10:00 ~ 12:00)")
                .min(2)
                .max(3)
                .lat(37.505819)
                .lng(126.946506)
                .address("제주특별자치도 서귀포시 성산읍 동류암로 26")
                .status('N')
                .money(37800)
                .detailAdd("22-2")
                .contact("010-")
                .build();

        Post post3 = Post.builder()
                .user(user1)
                .menu(menu3)
                .date("오늘")
                .realdate(LocalDate.now())
                .time("저녁 (16:00 ~ 18:00)")
                .min(2)
                .max(3)
                .contact("010-1234-1234")
                .lat(37.505383)
                .lng(126.94532)
                .address("제주특별자치도 서귀포시 성산읍 동류암로 20")
                .status('N')
                .money(50000)
                .detailAdd("201동 102호")

                .build();

        Post post4 = Post.builder()
                .user(user1)
                .menu(menu4)
                .date("내일")
                .time("아침 (8:00 ~ 10:00)")
                .contact("010-1234-1234")
                .realdate(LocalDate.of(2023, 10, 10))
                .detailAdd("103동 904호")
                .lat(37.505390)
                .lng(126.94745)
                .address("제주특별자치도 제주시 고마로13길 32")
                .status('N')
                .money(35000)
                .build();

        Post post5 = Post.builder()
                .user(user1)
                .menu(menu2)
                .date("내일")
                .time("점심 (12:00 ~ 14:00)")
                .min(2)
                .max(3)
                .detailAdd("5-2")
                .contact("010-1234-1234")
                .realdate(LocalDate.now())
                .lat(37.505370)
                .lng(126.94532)
                .address("제주특별자치도 서귀포시 성산읍 고성오조로 55")
                .status('N')
                .money(62000) // 추가: money 필드 초기화
                .build();

        Post post6 = Post.builder()
                .user(user1)
                .menu(menu6)
                .date("내일")
                .time("저녁 (16:00 ~ 18:00)")
                .min(2)
                .max(3)
                .lat(37.505353)
                .lng(126.94537)
                .address("제주특별자치도 서귀포시 성산읍 서성일로 1139")
                .status('N')
                .detailAdd("2-933")
                .contact("010-1234-1234")
                .realdate(LocalDate.now())
                .money(39000) // 추가: money 필드 초기화
                .build();

        Post post7 = Post.builder()
                .user(user1)
                .menu(menu7)
                .date("오늘")
                .time("저녁 (16:00 ~ 18:00)")
                .min(2)
                .max(3)
                .lat(37.505363)
                .lng(126.94550)
                .address("제주특별자치도제주시 첨단로 242")
                .status('N')
                .detailAdd("320동 201호")
                .contact("010-1234-1234")
                .realdate(LocalDate.now())
                .money(16000)
                .build();

        Post post8 = Post.builder()
                .user(user1)
                .menu(menu7)
                .date("오늘")
                .time("저녁 (16:00 ~ 18:00)")
                .min(1)
                .max(3)
                .lat(37.504363)
                .lng(126.94550)
                .address("제주특별자치도제주시 첨단로 280")
                .status('N')
                .detailAdd("320동 204호")
                .contact("010-1234-1234")
                .realdate(LocalDate.now())
                .money(35000)
                .build();

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);
        postRepository.save(post5);
        postRepository.save(post6);
        postRepository.save(post7);
        postRepository.save(post8);


        return "Initial setup completed";

    }

}

