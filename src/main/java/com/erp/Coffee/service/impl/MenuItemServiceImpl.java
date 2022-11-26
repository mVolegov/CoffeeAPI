package com.erp.Coffee.service.impl;

import com.erp.Coffee.exception.MenuItemNotFoundException;
import com.erp.Coffee.model.MenuItem;
import com.erp.Coffee.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl {

    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> findAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem findMenuItemById(Long id) {
        return menuItemRepository
                .findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Menu item by id " + id + " was not found"));
    }

    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItemById(Long id, MenuItem menuItem) {
        MenuItem menuItemByIdToUpdate = findMenuItemById(id);
        menuItemByIdToUpdate.setName(menuItem.getName());
        menuItemByIdToUpdate.setDescription(menuItem.getDescription());
        menuItemByIdToUpdate.setPrice(menuItem.getPrice());

        return menuItemRepository.save(menuItemByIdToUpdate);
    }

    public void deleteMenuItemById(Long id) {
        menuItemRepository.deleteById(id);
    }
}
