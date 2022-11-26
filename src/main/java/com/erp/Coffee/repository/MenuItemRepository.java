package com.erp.Coffee.repository;

import com.erp.Coffee.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    MenuItem findMenuItemById(Long id);
}
