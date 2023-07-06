package com.groom.groom.service;

import com.groom.groom.domain.Matching;
import com.groom.groom.domain.Menu;
import com.groom.groom.domain.Post;
import com.groom.groom.domain.Users;
import com.groom.groom.dto.MenuSaveDto;
import com.groom.groom.repository.MatchingRepository;
import com.groom.groom.repository.PostRepository;
import com.groom.groom.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchingService {
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;
    private final MatchingRepository matchingRepository;
    @Transactional
    public Matching saveMatching(int post_idx, int user_idx){
        Post post = postRepository.findById(post_idx)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        Users user = usersRepository.findById(user_idx)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        Matching matching = new Matching(user, post);

        return matchingRepository.save(matching);
    }



    //매칭 신청자 리스트
    public List<Matching> getMatchRequestsByPost(int post_idx) {
        Post post = postRepository.findById(post_idx)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return matchingRepository.findByPost(post);
    }
}
