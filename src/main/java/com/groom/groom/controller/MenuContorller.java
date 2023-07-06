package com.groom.groom.controller;


import com.groom.groom.domain.Menu;
import com.groom.groom.dto.MenuSaveDto;
import com.groom.groom.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/listall")
    @Operation(summary = "menu/listall", description = "메뉴 전체보기")
    public ResponseEntity<List<Menu>> findAllPosts(){
        List<Menu> list = menuService.findAll(); // 메뉴 전체를 조회하는 메소드 호출
        return ResponseEntity.status(HttpStatus.OK).body(list); // 조회된 메뉴 리스트를 응답으로 반환
    }



}
