package com.groom.groom.controller;

import com.groom.groom.domain.Menu;
import com.groom.groom.domain.Post;
import com.groom.groom.domain.Users;
import com.groom.groom.repository.MenuRepository;
import com.groom.groom.repository.PostRepository;
import com.groom.groom.repository.UsersRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

        Menu menu1 = new Menu("구살국(성게국)", "옛 제주에서 귀한 손님을 위해 대접한 음식");
        Menu menu2 = new Menu("자리돔조림", "제주 연안에서 서식하는 자리돔을 간장으로 조린 음식");
        Menu menu3 = new Menu("한치 물회 덮밥", "싱싱한 오징어와 된장, 식초를 곁들인 물회");
        Menu menu4 = new Menu("갈치 조림", "갈치조림 설명 추가");
        Menu menu5 = new Menu("고기 국수", "고기 국수 설명 추가");

        menuRepository.save(menu1);
        menuRepository.save(menu2);
        menuRepository.save(menu3);
        menuRepository.save(menu4);
        menuRepository.save(menu5);

        Post post1 = new Post();
        post1.setUser(user1);
        post1.setMenu(menu1);
        post1.setDate("오늘");
        post1.setTime("아침");
        post1.setNumber(1);
        post1.setApplication(0);
        List<String> item = new ArrayList<>();
        item.add("어류");
        post1.setItem(item);
        post1.setLat(33.449967);
        post1.setLng(126.918558);
        post1.setAddress("제주특별자치도 서귀포시 성산읍 동류암로 20");
        post1.setStatus('N');

        Post post2 = new Post();
        post2.setUser(user1);
        post2.setMenu(menu2);
        post2.setDate("오늘");
        post2.setTime("점심");
        post2.setNumber(2);
        post2.setApplication(0);
        List<String> item2 = new ArrayList<>();
        item2.add("어류");
        post2.setItem(item2);
        post2.setLat(33.449701);
        post2.setLng(126.917109);
        post2.setAddress("제주특별자치도 서귀포시 성산읍 동류암로 26");
        post2.setStatus('N');


        Post post3 = new Post();
        post3.setUser(user1);
        post3.setMenu(menu3);
        post3.setDate("오늘");
        post3.setTime("저녁");
        post3.setNumber(3);
        post3.setApplication(0);
        List<String> item3 = new ArrayList<>();
        item3.add("어류");
        item3.add("과일");
        post3.setItem(item3);
        post3.setLat(33.449967);
        post3.setLng(126.918558);
        post3.setAddress("제주특별자치도 서귀포시 성산읍 동류암로 20");
        post3.setStatus('N');


        Post post4 = new Post();
        post4.setUser(user1);
        post4.setMenu(menu4);
        post4.setDate("내일");
        post4.setTime("아침");
        post4.setNumber(4);
        post4.setApplication(0);
        List<String> item4 = new ArrayList<>();
        item4.add("채소");
        post4.setItem(item4);
        post4.setLat(33.450285);
        post4.setLng(126.91751);
        post4.setAddress("제주특별자치도 제주시 고마로13길 32");
        post4.setStatus('N');


        Post post5 = new Post();
        post5.setUser(user1);
        post5.setMenu(menu5);
        post5.setDate("내일");
        post5.setTime("점심");
        post5.setNumber(2);
        post5.setApplication(0);
        List<String> item5 = new ArrayList<>();
        item5.add("육류");
        post5.setItem(item5);
        post5.setLat(33.449148);
        post5.setLng(126.913911);
        post5.setAddress("제주특별자치도 서귀포시 성산읍 고성오조로 55");
        post5.setStatus('N');


        Post post6 = new Post();
        post6.setUser(user1);
        post6.setMenu(menu1);
        post6.setDate("내일");
        post6.setTime("저녁");
        post6.setNumber(3);
        post6.setApplication(0);
        List<String> item6 = new ArrayList<>();
        item6.add("어류");
        item6.add("채소");
        post6.setItem(item6);
        post6.setLat(33.445487);
        post6.setLng(126.900651);
        post6.setAddress("제주특별자치도 서귀포시 성산읍 서성일로 1139");
        post6.setStatus('N');

        Post post7 = new Post();
        post7.setUser(user1);
        post7.setMenu(menu2);
        post7.setDate("오늘");
        post7.setTime("저녁");
        post7.setNumber(1);
        post7.setApplication(0);
        List<String> item7 = new ArrayList<>();
        item7.add("과일");
        post7.setItem(item7);
        post7.setLat(33.450701);
        post7.setLng(126.570667);
        post7.setAddress("제주특별자치도 제주시 첨단로 242");
        post7.setStatus('N');

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
