package com.groom.groom.service;


import com.groom.groom.domain.Menu;
import com.groom.groom.domain.Users;
import com.groom.groom.dto.MenuSaveDto;
import com.groom.groom.repository.MenuRepository;
import com.groom.groom.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service

public class MenuService {
    private final MenuRepository menuRepository;


    @Transactional
    public Menu saveMenu(MenuSaveDto menuSaveDto){
        Menu menu = menuSaveDto.toEntity();
        menuRepository.save(menu);
        return menu;
    }
}
