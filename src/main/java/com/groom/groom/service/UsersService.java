package com.groom.groom.service;

import com.groom.groom.domain.Users;
import com.groom.groom.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service

public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    public Users saveUsers(String id){
        Users users = new Users();
        users.setId(id);
        return usersRepository.save(users);
    }

    @Transactional
    public Users findById(int idx){
        Users entity = usersRepository.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 유저가 없습니다. id="+idx));
        return entity;
    }

}
