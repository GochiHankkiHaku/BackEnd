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
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public Post save(PostSaveDto postSaveDto){

        Users user = new Users();
        user.setId("a");
        usersRepository.save(user);
        postSaveDto.setUser(user);

        String menuname = postSaveDto.getMenuname();
        Menu menu = menuRepository.findByName(menuname); // 메뉴 이름으로 메뉴 조회
        if (menu == null) {
            // 메뉴가 존재하지 않는 경우에 대한 예외 처리
            throw new IllegalArgumentException("해당 메뉴를 찾을 수 없습니다: " + menuname);
        }

        List<String> items = postSaveDto.getItem();
        String category = determineCategory(items);

        Post post = postSaveDto.toEntity();
        post.setMenu(menu);
        post.setCategory(category);
        postRepository.save(post);
        return post;
    }
    //카테고리 분류 함수
    private String determineCategory(List<String> items) {
        boolean hasMeat = false;
        boolean hasFish = false;
        boolean hasVegetable = false;

        for (String item : items) {
            if (item.equals("돼지고기") || item.equals("소고기") || item.equals("말고기")) {
                hasMeat = true;
            } else if (item.equals("갈치") || item.equals("고등어")) {
                hasFish = true;
            } else if (item.equals("배추") || item.equals("양파")) {
                hasVegetable = true;
            }
        }

        if (hasMeat && !hasFish && !hasVegetable) {
            return "육류";
        } else if (!hasMeat && hasFish && !hasVegetable) {
            return "어패류";
        } else if (!hasMeat && !hasFish && hasVegetable) {
            return "채소";
        } else {
            return "기타";
        }
    }

    //맵 상세정보 리스트
    @Transactional
    public List<PostListDto> findByPost_notstatus(char flag){
        List<Post> list = postRepository.findAllByStatusNot(flag);
        return list.stream().map(PostListDto::new).collect(Collectors.toList());
    }

    //상세 정보
    @Transactional
    public PostResponseDto findById(int idx){
        Post entity= postRepository.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+idx));
        return new PostResponseDto(entity);
    }

    //수정
    @Transactional
    public Post update(int idx, PostUpdateDto requestDto){
        Post post = postRepository.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+idx));
        Menu menu = menuRepository.findByName(requestDto.getMenuname()); // 메뉴 이름으로 메뉴 조회
        post.update(menu,requestDto.getContent(),  requestDto.getTime(),requestDto.getNumber(), requestDto.getItem(), requestDto.getCategory());
        return post;
    }
    //삭제
    @Transactional
    public void delete(int idx){
        Post entity = postRepository.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+idx));
        entity.delete();
    }

}
