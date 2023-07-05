package com.groom.groom.controller;


import com.groom.groom.domain.Menu;
import com.groom.groom.dto.MenuSaveDto;
import com.groom.groom.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "menu", description = "메뉴")
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuContorller {
    private final MenuService menuService;
    @PostMapping("/save")
    @Operation(summary = "menu/save", description = "메뉴추가")
    public ResponseEntity<Menu> save(@RequestBody MenuSaveDto menuSaveDto){
        Menu menu = menuService.saveMenu(menuSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(menu);
    }

}
