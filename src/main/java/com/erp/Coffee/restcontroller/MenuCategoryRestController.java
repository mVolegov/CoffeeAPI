package com.erp.Coffee.restcontroller;

import com.erp.Coffee.model.MenuCategory;
import com.erp.Coffee.service.MenuCategoryService;
import com.erp.Coffee.service.impl.MenuCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu-categories")
public class MenuCategoryRestController {

    private final MenuCategoryService menuCategoryService;

    @Autowired
    public MenuCategoryRestController(@Qualifier("menuCategoryServiceImpl") MenuCategoryService menuCategoryService) {
        this.menuCategoryService = menuCategoryService;
    }

    /**
     * Получение всех категорий меню
     */
    @GetMapping
    public ResponseEntity<List<MenuCategory>> getAllMenuCategories() {
        List<MenuCategory> allMenuCategories = menuCategoryService.findAllMenuCategories();
        return new ResponseEntity<>(allMenuCategories, HttpStatus.OK);
    }
}
