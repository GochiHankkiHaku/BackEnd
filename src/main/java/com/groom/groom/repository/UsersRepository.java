package com.groom.groom.repository;

import com.groom.groom.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository  extends JpaRepository<Users, Integer> {
    Optional<Users> findById(String id);

}
