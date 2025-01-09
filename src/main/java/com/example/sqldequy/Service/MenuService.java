package com.example.sqldequy.Service;

import com.example.sqldequy.DTO.MenuDTO;
import com.example.sqldequy.Entity.MenuEntity;
import com.example.sqldequy.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<MenuEntity> getMenus(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);  // page - 1 vì Spring bắt đầu từ trang 0
        return menuRepository.findAll(pageable);
    }
    public Page<MenuEntity> getMenus(int page, int size, String orderColumn, String orderDirection) {
        // Kiểm tra hướng sắp xếp và áp dụng Sort.Direction
        Sort.Direction direction = Sort.Direction.fromString(orderDirection);

        // Tạo Pageable từ các tham số, sử dụng cột và hướng sắp xếp
        Pageable pageable = PageRequest.of(page - 1, size, direction, orderColumn);  // page bắt đầu từ 0

        // Trả về các bản ghi phân trang với sắp xếp
        return menuRepository.findAll(pageable);
    }


}
