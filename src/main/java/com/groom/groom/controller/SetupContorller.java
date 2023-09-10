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
        Users user1 = new Users("a");
        Users user2 = new Users("b" );
        usersRepository.save(user1);
        usersRepository.save(user2);


        List<MenuItem> item1 = new ArrayList<>();

        item1.add(MenuItem.builder().idx(0).ingredient("성게").price(10000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item1.add(MenuItem.builder().idx(1).ingredient("고사리").price(2000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item1.add(MenuItem.builder().idx(2).ingredient("대추").price(2000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item1.add(MenuItem.builder().idx(3).ingredient("마늘").price(2000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item1.add(MenuItem.builder().idx(4).ingredient("고추가루").price(2000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item1.add(MenuItem.builder().idx(5).ingredient("된장").price(2000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());

        List<MenuItem> item2 = new ArrayList<>();
        item2.add(MenuItem.builder().idx(0).ingredient("자리돔").price(10000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item2.add(MenuItem.builder().idx(1).ingredient("간장").price(2000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item2.add(MenuItem.builder().idx(2).ingredient("설탕").price(2000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item2.add(MenuItem.builder().idx(3).ingredient("생강").price(2000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item2.add(MenuItem.builder().idx(4).ingredient("고추장").price(2000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());


        List<MenuItem> item3 = new ArrayList<>();
        item3.add(MenuItem.builder().idx(0).ingredient("한치").price(10000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item3.add(MenuItem.builder().idx(1).ingredient("양배추").price(3000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item3.add(MenuItem.builder().idx(2).ingredient("미나리").price(3000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item3.add(MenuItem.builder().idx(3).ingredient("오이").price(3000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());
        item3.add(MenuItem.builder().idx(4).ingredient("배").price(3000).url("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png").build());




        Menu menu1 = new Menu("구살국(성게국)", "옛 제주에서 귀한 손님을 위해 대접한 음식", item1, "https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png",0);
        Menu menu2 = new Menu("자리돔조림", "제주 연안에서 서식하는 자리돔을 간장으로 조린 음식", item2, "https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%8C%E1%85%A1%E1%84%85%E1%85%B5%E1%84%83%E1%85%A9%E1%86%B7%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.png",0);
        Menu menu3 = new Menu("한치 물회 덮밥", "싱싱한 오징어와 된장, 식초를 곁들인 물회", item3, "https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/%EB%8C%80%EC%A7%80%201%20%EC%82%AC%EB%B3%B8%209.png",0);

        menuRepository.save(menu1);
        menuRepository.save(menu2);
        menuRepository.save(menu3);




        Post post1 = Post.builder()
                .user(user1)
                .menu(menu1)
                .date("오늘")
                .time("아침 (8:00 ~ 10:00)")
                .min(1)
                .max(3)
                .lat(37.505385)
                .lng(126.942561)
                .address("제주특별자치도 서귀포시 성산읍 동류암로 20")
                .detailAdd("000동 000호")
                .status('N')
                .contact("010-")
                .money(20000)
                .build();



        Post post2 = Post.builder()
                .user(user1)
                .menu(menu2)
                .date("오늘")
                .time("점심 (10:00 ~ 12:00)")
                .min(2)
                .max(3)
                .lat(37.505819)
                .lng(126.946506)
                .address("제주특별자치도 서귀포시 성산읍 동류암로 26")
                .status('N')
                .money(20000) // 추가: money 필드 초기화
                .detailAdd("000동 000호")
                .contact("010-")
                .build();

        Post post3 = Post.builder()
                .user(user1)
                .menu(menu3)
                .date("오늘")
                .time("저녁 (16:00 ~ 18:00)")
                .min(2)
                .max(3)
                .contact("010-")

                .lat(37.505383)
                .lng(126.94532)
                .address("제주특별자치도 서귀포시 성산읍 동류암로 20")
                .status('N')
                .money(20000) // 추가: money 필드 초기화
                .detailAdd("000동 000호")

                .build();

        Post post4 = Post.builder()
                .user(user1)
                .menu(menu3)
                .date("내일")
                .time("아침 (8:00 ~ 10:00)")
                .contact("010-")

                .detailAdd("000동 000호")
                .lat(37.505390)
                .lng(126.94745)
                .address("제주특별자치도 제주시 고마로13길 32")
                .status('N')
                .money(20000) // 추가: money 필드 초기화
                .build();

        Post post5 = Post.builder()
                .user(user1)
                .menu(menu2)
                .date("내일")
                .time("점심 (12:00 ~ 14:00)")
                .min(2)
                .max(3)
                .detailAdd("000동 000호")
                .contact("010-")

                .lat(37.505370)
                .lng(126.94532)
                .address("제주특별자치도 서귀포시 성산읍 고성오조로 55")
                .status('N')
                .money(20000) // 추가: money 필드 초기화
                .build();

        Post post6 = Post.builder()
                .user(user1)
                .menu(menu1)
                .date("내일")
                .time("저녁 (16:00 ~ 18:00)")
                .min(2)
                .max(3)
                .lat(37.505353)
                .lng(126.94537)
                .address("제주특별자치도 서귀포시 성산읍 서성일로 1139")
                .status('N')
                .detailAdd("000동 000호")
                .contact("010-")

                .money(20000) // 추가: money 필드 초기화
                .build();

        Post post7 = Post.builder()
                .user(user1)
                .menu(menu2)
                .date("오늘")
                .time("저녁 (16:00 ~ 18:00)")
                .min(2)
                .max(3)
                .lat(37.505363)
                .lng(126.94550)
                .address("제주특별자치도제주시 첨단로 242")
                .status('N')
                .detailAdd("000동 000호")
                .contact("010-")

                .money(20000) // 추가: money 필드 초기화
                .build();

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);
        postRepository.save(post5);
        postRepository.save(post6);
        postRepository.save(post7);


        return "Initial setup completed";

    }

}

