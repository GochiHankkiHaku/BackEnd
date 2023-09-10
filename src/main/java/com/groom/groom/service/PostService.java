package com.groom.groom.service;

import com.groom.groom.domain.Menu;
import com.groom.groom.domain.Post;
import com.groom.groom.domain.Users;
import com.groom.groom.dto.PostResponseDto;
import com.groom.groom.dto.PostSaveDto;
import com.groom.groom.dto.PostListDto;
import com.groom.groom.dto.PostUpdateDto;
import com.groom.groom.repository.MenuRepository;
import com.groom.groom.repository.PostRepository;
import com.groom.groom.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;
    private final MenuRepository menuRepository;


    @Transactional
    public Post save(PostSaveDto postSaveDto) {
        Users user = usersRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
        usersRepository.save(user);
        postSaveDto.setUser(user);

        String menuname = postSaveDto.getMenuname();
        Menu menu = menuRepository.findByName(menuname);
        menu.chooseUp();
        menuRepository.save(menu);

        Post post = postSaveDto.toEntity();
        post.setMenu(menu);
        postRepository.save(post);
        return post;
    }

    //맵 상세정보 리스트
    @Transactional
    public List<PostListDto> findByPost_notstatus(char flag){
        List<Post> list = postRepository.findAllByStatusNot(flag);
        return list.stream().map(PostListDto::new).collect(Collectors.toList());
    }

    public List<Post> findPostsNearby(double userLat, double userLng) {
        List<Post> allPosts = postRepository.findAll();  // 모든 게시글 조회

        List<Post> nearbyPosts = new ArrayList<>();
        for (Post post : allPosts) {
            double postLat = post.getLat();  // 게시글의 위도
            double postLng = post.getLng();  // 게시글의 경도

            double distance = calculateDistance(userLat, userLng, postLat, postLng);
            if (distance <= 1.0) {  // 1km 반경 내에 있는 게시글인 경우
                nearbyPosts.add(post);
            }
        }

        return nearbyPosts;
    }
    public static final double EARTH_RADIUS = 6371.0;

    public double calculateDistance(double lat1, double lng1, double lat2, double lng2) {
        double lat1Rad = Math.toRadians(lat1);
        double lng1Rad = Math.toRadians(lng1);
        double lat2Rad = Math.toRadians(lat2);
        double lng2Rad = Math.toRadians(lng2);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLng = lng2Rad - lng1Rad;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(deltaLng / 2) * Math.sin(deltaLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = EARTH_RADIUS * c;
        return distance;
    }


    //상세 정보
    @Transactional
    public PostResponseDto findById(int idx){
        Post entity= postRepository.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+idx));
        System.out.print(entity.getMenu().getItem()); // item 로딩
        return new PostResponseDto(entity);
    }

    //수정
    @Transactional
    public Post update(int idx, PostUpdateDto requestDto){
        Post post = postRepository.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+idx));
        Menu menu = menuRepository.findByName(requestDto.getMenuname()); // 메뉴 이름으로 메뉴 조회
        post.update(menu,requestDto.getDate(), requestDto.getTime(),requestDto.getMin(),requestDto.getMax(), requestDto.getLat(),
                requestDto.getLng(), requestDto.getMoney(),requestDto.getContact(),
                requestDto.getAddress(), requestDto.getDetailAdd());
        return post;
    }
    //삭제
    @Transactional
    public void delete(int idx){
        Post entity = postRepository.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+idx));
        entity.delete();
    }

    //완료
    @Transactional
    public void complete(int idx){
        Post entity = postRepository.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+idx));
        entity.complete();
    }

}
