package com.example.sqldequy.Repository;

import com.example.sqldequy.Entity.MenuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

    List<MenuEntity> findByParentIdIsNull();

    List<MenuEntity> findByParentId(Integer parentId);

//    @Query("SELECT m FROM MenuEntity m ORDER BY m.id ASC")
//    List<MenuEntity> findMenuWithPagination(int limit, int offset);

    @Query("SELECT m FROM MenuEntity m ORDER BY m.id ASC")
    Page<MenuEntity> findMenuWithPagination(Pageable pageable);

    Page<MenuEntity> findAll(Pageable pageable);
}
