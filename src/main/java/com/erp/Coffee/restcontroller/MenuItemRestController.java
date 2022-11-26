package com.erp.Coffee.restcontroller;

import com.erp.Coffee.model.MenuItem;
import com.erp.Coffee.service.impl.MenuItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu-items")
public class MenuItemRestController {

    private final MenuItemServiceImpl menuItemServiceImpl;

    @Autowired
    public MenuItemRestController(MenuItemServiceImpl menuItemServiceImpl) {
        this.menuItemServiceImpl = menuItemServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemServiceImpl.findAllMenuItems();
        return new ResponseEntity<>(menuItems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable("id") Long id) {
        MenuItem menuItem = menuItemServiceImpl.findMenuItemById(id);
        return new ResponseEntity<>(menuItem, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MenuItem> addMenuElement(@RequestBody MenuItem menuItem) {
        MenuItem createdMenuItem = menuItemServiceImpl.addMenuItem(menuItem);
        return new ResponseEntity<>(createdMenuItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable("id") Long id, @RequestBody MenuItem menuItem) {
        MenuItem updatedMenuItem = menuItemServiceImpl.updateMenuItemById(id, menuItem);
        return new ResponseEntity<>(updatedMenuItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable("id") Long id) {
        menuItemServiceImpl.deleteMenuItemById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
