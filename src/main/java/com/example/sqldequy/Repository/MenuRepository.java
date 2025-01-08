package com.example.sqldequy.Repository;

import com.example.sqldequy.Entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

    List<MenuEntity> findByParentIdIsNull();

    List<MenuEntity> findByParentId(Integer parentId);
}
