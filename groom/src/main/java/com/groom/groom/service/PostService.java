package com.groom.groom.service;

import com.groom.groom.domain.Post;
import com.groom.groom.domain.Users;
import com.groom.groom.dto.PostSaveDto;
import com.groom.groom.repository.PostRepository;
import com.groom.groom.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;

    @Transactional
    public Post save(PostSaveDto postSaveDto){

        Users user = new Users();
        user.setId("a");
        usersRepository.save(user);
        postSaveDto.setUser(user);

        Post post = postSaveDto.toEntity();
        postRepository.save(post);
        return post;
    }

}
