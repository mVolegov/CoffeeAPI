package com.erp.Coffee.restcontroller;

import com.erp.Coffee.model.MenuCategory;
import com.erp.Coffee.service.impl.MenuCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu-categories")
public class MenuCategoryRestController {

    private final MenuCategoryServiceImpl menuCategoryServiceImpl;

    @Autowired
    public MenuCategoryRestController(MenuCategoryServiceImpl menuCategoryServiceImpl) {
        this.menuCategoryServiceImpl = menuCategoryServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<MenuCategory>> getAllMenuCategories() {
        List<MenuCategory> allMenuCategories = menuCategoryServiceImpl.findAllMenuCategories();
        return new ResponseEntity<>(allMenuCategories, HttpStatus.OK);
    }
}
