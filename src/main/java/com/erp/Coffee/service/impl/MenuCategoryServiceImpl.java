package com.erp.Coffee.service.impl;

import com.erp.Coffee.model.MenuCategory;
import com.erp.Coffee.repository.MenuCategoryRepository;
import com.erp.Coffee.service.MenuCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuCategoryServiceImpl")
public class MenuCategoryServiceImpl implements MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;

    @Autowired
    public MenuCategoryServiceImpl(MenuCategoryRepository menuCategoryRepository) {
        this.menuCategoryRepository = menuCategoryRepository;
    }

    @Override
    public List<MenuCategory> findAllMenuCategories() {
        return menuCategoryRepository.findAll();
    }
}
