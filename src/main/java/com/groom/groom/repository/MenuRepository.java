package com.groom.groom.repository;
import com.groom.groom.domain.Menu;

import com.groom.groom.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Menu findByName(String name);
}
