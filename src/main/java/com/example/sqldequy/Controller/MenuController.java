package com.example.sqldequy.Controller;

import com.example.sqldequy.DTO.MenuDTO;
import com.example.sqldequy.Entity.MenuEntity;
import com.example.sqldequy.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping()
    public List<MenuDTO> getMenuList() {
        return menuService.getMenuList();
    }
    @GetMapping("/menus")
    public Page<MenuEntity> getMenus(@RequestParam int page, @RequestParam int size) {
        return menuService.getMenus(page, size);
    }
    @GetMapping("/get")
    public Page<MenuEntity> getMenus(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String orderColumn,
            @RequestParam(defaultValue = "ASC") String orderDirection
    ) {
        return menuService.getMenus(page, size, orderColumn, orderDirection);
    }
}
