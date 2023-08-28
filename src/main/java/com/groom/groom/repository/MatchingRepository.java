package com.groom.groom.repository;

import com.groom.groom.domain.Matching;
import com.groom.groom.domain.Post;
import com.groom.groom.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchingRepository extends JpaRepository<Matching, Integer> {
    List<Matching> findByPost(Post post);
    List<Matching> findByUser(Users user);

    Matching findByUserAndPost(Users user, Post post);
}
