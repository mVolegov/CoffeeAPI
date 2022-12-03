package com.erp.Coffee.service.impl;

import com.erp.Coffee.exception.MenuItemNotFoundException;
import com.erp.Coffee.model.MenuItem;
import com.erp.Coffee.repository.MenuItemRepository;
import com.erp.Coffee.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuItemServiceImpl")
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> findAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem findMenuItemById(Long id) {
        return menuItemRepository
                .findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Menu item by id " + id + " was not found"));
    }

    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItemById(Long id, MenuItem menuItem) {
        MenuItem menuItemByIdToUpdate = findMenuItemById(id);
        menuItemByIdToUpdate.setName(menuItem.getName());
        menuItemByIdToUpdate.setDescription(menuItem.getDescription());
        menuItemByIdToUpdate.setPrice(menuItem.getPrice());

        return menuItemRepository.save(menuItemByIdToUpdate);
    }

    @Override
    public void deleteMenuItemById(Long id) {
        menuItemRepository.deleteById(id);
    }
}
