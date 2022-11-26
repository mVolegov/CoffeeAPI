package com.erp.Coffee.service.impl;

import com.erp.Coffee.model.MenuCategory;
import com.erp.Coffee.repository.MenuCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuCategoryServiceImpl {

    private final MenuCategoryRepository menuCategoryRepository;

    @Autowired
    public MenuCategoryServiceImpl(MenuCategoryRepository menuCategoryRepository) {
        this.menuCategoryRepository = menuCategoryRepository;
    }

    public List<MenuCategory> findAllMenuCategories() {
        return menuCategoryRepository.findAll();
    }
}
