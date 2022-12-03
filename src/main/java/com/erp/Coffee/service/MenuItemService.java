package com.erp.Coffee.service;

import com.erp.Coffee.model.MenuItem;

import java.util.List;

public interface MenuItemService {

    List<MenuItem> findAllMenuItems();

    MenuItem findMenuItemById(Long id);

    MenuItem addMenuItem(MenuItem menuItem);

    MenuItem updateMenuItemById(Long id, MenuItem menuItem);

    void deleteMenuItemById(Long id);
}
