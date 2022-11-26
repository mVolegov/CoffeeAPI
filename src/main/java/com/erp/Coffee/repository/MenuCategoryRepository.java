package com.erp.Coffee.repository;

import com.erp.Coffee.model.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

    MenuCategory findMenuCategoryById(Long id);
}
