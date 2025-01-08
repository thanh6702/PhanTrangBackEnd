package com.example.sqldequy.Service;

import com.example.sqldequy.DTO.MenuDTO;
import com.example.sqldequy.Entity.MenuEntity;
import com.example.sqldequy.Repository.MenuRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<MenuDTO> getMenuList() {
        List<MenuEntity> rootMenus = menuRepository.findByParentIdIsNull();
        return buildMenuList(rootMenus);
    }

    private List<MenuDTO> buildMenuList(List<MenuEntity> menus) {
        List<MenuDTO> result = new ArrayList<>();

        for (MenuEntity menu : menus) {
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setId(menu.getId());
            menuDTO.setName(menu.getName());
            menuDTO.setParentId(menu.getParentId());
            menuDTO.setType(menu.getType());
            menuDTO.setCreatedAt(menu.getCreatedAt());
            menuDTO.setUpdatedAt(menu.getUpdatedAt());

            List<MenuEntity> childMenus = menuRepository.findByParentId(menu.getId());
            List<MenuDTO> childMenuDTOs = buildMenuList(childMenus);

            menuDTO.setListCon(childMenuDTOs);

            result.add(menuDTO);
        }

        return result;
    }


}
