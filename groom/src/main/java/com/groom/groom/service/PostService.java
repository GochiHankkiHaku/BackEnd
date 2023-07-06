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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

        Post post = postSaveDto.toEntity();
        post.setMenu(menu);
        postRepository.save(post);
        return post;
    }

    //맵 상세정보 리스트
    @Transactional
    public List<PostListDto> findByPost_status(char flag){
        List<Post> list = postRepository.findALlByStatus(flag);
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
        post.update(requestDto.getMenu(),requestDto.getContent(),  requestDto.getTime(),requestDto.getNumber(), requestDto.getItem(), requestDto.getCategory());
        return post;
    }
    //삭제
    @Transactional
    public void delete(int idx){
        Post entity = postRepository.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+idx));
        entity.delete();
    }

}
