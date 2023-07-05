package com.groom.groom.repository;
import com.groom.groom.domain.Menu;

import org.springframework.data.jpa.repository.JpaRepository;



public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
