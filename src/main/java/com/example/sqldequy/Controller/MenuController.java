package com.example.sqldequy.Controller;

import com.example.sqldequy.DTO.MenuDTO;
import com.example.sqldequy.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
