package com.groom.groom.controller;

import com.groom.groom.domain.Menu;
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

        List<String> item = new ArrayList<>();
        item.add("성게알");
        item.add("미역");
        item.add("청장");
        item.add("참기름");
        item.add("소금");

        List<String> item2 = new ArrayList<>();
        item2.add("자리돔");
        item2.add("간장");
        item2.add("설탕");
        item2.add("다진 마늘");
        item2.add("식초");
        item2.add("고춧가루");

        List<String> item3 = new ArrayList<>();
        item3.add("한치");
        item3.add("쌀");
        item3.add("배");
        item3.add("무");
        item3.add("오이");
        item3.add("당근");
        item3.add("미나리");

        Menu menu1 = new Menu("구살국(성게국)", "옛 제주에서 귀한 손님을 위해 대접한 음식", item);
        Menu menu2 = new Menu("자리돔조림", "제주 연안에서 서식하는 자리돔을 간장으로 조린 음식", item2);
        Menu menu3 = new Menu("한치 물회 덮밥", "싱싱한 오징어와 된장, 식초를 곁들인 물회", item3);


        menuRepository.save(menu1);
        menuRepository.save(menu2);
        menuRepository.save(menu3);


        System.out.println(item);


        Post post1 = Post.builder()
                .user(user1)
                .menu(menu1)
                .date("오늘")
                .time("아침")
                .number(1)
                .application(0)
                .lat(33.449967)
                .lng(126.918558)
                .address("제주특별자치도 서귀포시 성산읍 동류암로 20")
                .status('N')
                .money(20000)
                .img("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png")
                .build();



        Post post2 = Post.builder()
                .user(user1)
                .menu(menu2)
                .date("오늘")
                .time("점심")
                .number(2)
                .application(1)
                .lat(33.449701)
                .lng(126.917109)
                .address("제주특별자치도 서귀포시 성산읍 동류암로 26")
                .status('N')
                .money(20000) // 추가: money 필드 초기화
                .img("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%8C%E1%85%A1%E1%84%85%E1%85%B5%E1%84%83%E1%85%A9%E1%86%B7%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.png")
                .build();

        Post post3 = Post.builder()
                .user(user1)
                .menu(menu3)
                .date("오늘")
                .time("저녁")
                .number(3)
                .application(1)
                .lat(33.449967)
                .lng(126.918558)
                .address("제주특별자치도 서귀포시 성산읍 동류암로 20")
                .status('N')
                .money(20000) // 추가: money 필드 초기화
                .img("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/%EB%8C%80%EC%A7%80%201%20%EC%82%AC%EB%B3%B8%209.png")
                .build();

        Post post4 = Post.builder()
                .user(user1)
                .menu(menu3)
                .date("내일")
                .time("아침")
                .number(4)
                .application(2)
                .lat(33.450285)
                .lng(126.91751)
                .address("제주특별자치도 제주시 고마로13길 32")
                .status('N')
                .money(20000) // 추가: money 필드 초기화
                .img("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/%EB%8C%80%EC%A7%80%201%20%EC%82%AC%EB%B3%B8%209.png")
                .build();

        Post post5 = Post.builder()
                .user(user1)
                .menu(menu2)
                .date("내일")
                .time("점심")
                .number(2)
                .application(1)
                .lat(33.449148)
                .lng(126.913911)
                .address("제주특별자치도 서귀포시 성산읍 고성오조로 55")
                .status('N')
                .money(20000) // 추가: money 필드 초기화
                .img("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%8C%E1%85%A1%E1%84%85%E1%85%B5%E1%84%83%E1%85%A9%E1%86%B7%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.png")
                .build();

        Post post6 = Post.builder()
                .user(user1)
                .menu(menu1)
                .date("내일")
                .time("저녁")
                .number(3)
                .application(0)
                .lat(33.445487)
                .lng(126.900651)
                .address("제주특별자치도 서귀포시 성산읍 서성일로 1139")
                .status('N')
                .money(20000) // 추가: money 필드 초기화
                .img("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%89%E1%85%A5%E1%86%BC%E1%84%80%E1%85%A6%E1%84%80%E1%85%AE%E1%86%A8.png")
                .build();

        Post post7 = Post.builder()
                .user(user1)
                .menu(menu2)
                .date("오늘")
                .time("저녁")
                .number(1)
                .application(0)
                .lat(33.450701)
                .lng(126.570667)
                .address("제주특별자치도제주시 첨단로 242")
                .status('N')
                .money(20000) // 추가: money 필드 초기화
                .img("https://hibit2bucket.s3.ap-northeast-2.amazonaws.com/m_%E1%84%8C%E1%85%A1%E1%84%85%E1%85%B5%E1%84%83%E1%85%A9%E1%86%B7%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.png")
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
