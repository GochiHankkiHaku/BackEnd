package com.groom.groom.service;

import com.groom.groom.domain.*;
import com.groom.groom.dto.MenuSaveDto;
import com.groom.groom.repository.MatchingRepository;
import com.groom.groom.repository.PostRepository;
import com.groom.groom.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchingService {
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;
    private final MatchingRepository matchingRepository;
    @Transactional
    public Matching saveMatching(int post_idx, int user_idx, String contact){
        Post post = postRepository.findById(post_idx)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        Users user = usersRepository.findById(user_idx)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        Matching matching = new Matching(user, post.getUser(), post, contact);

        return matchingRepository.save(matching);
    }

    //매칭 신청자 리스트
    public List<Matching> getMatchRequestsByPost(int post_idx) {
        Post post = postRepository.findById(post_idx)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return matchingRepository.findByPost(post);
    }

    //매칭글 신청 리스트
    public List<Matching> getMatchRequestsByUser(int user_idx) {
        Users user = usersRepository.findById(user_idx)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        return matchingRepository.findByUser(user);
    }


    public void okMatch(int matching_idx) {
        Matching matching = matchingRepository.findById(matching_idx)
                .orElseThrow(() -> new RuntimeException("매칭 신청을 찾을 수 없습니다."));
        matching.setStatus(MatchingStatus.OK);
        matchingRepository.save(matching);
    }

    public void noMatch(int matching_idx) {
        Matching matching = matchingRepository.findById(matching_idx)
                .orElseThrow(() -> new RuntimeException("매칭 신청을 찾을 수 없습니다."));
        matching.setStatus(MatchingStatus.NO);
        matchingRepository.save(matching);
    }


    @Transactional
    public List<Matching> getMatchingsByUser(int user_idx) {
        Users user = usersRepository.findById(user_idx)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        return matchingRepository.findByUser(user);
    }

    @Transactional
    public List<Matching> getMatchingsByOpener(int user_idx) {
        Users user = usersRepository.findById(user_idx)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        System.out.println(user);
        return matchingRepository.findByOpener(user);
    }

}
