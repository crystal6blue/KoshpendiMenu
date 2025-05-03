package com.project.koshpendimenu1.Service.MenuService;


import com.project.koshpendimenu1.Model.Menu;

import java.util.Optional;

public interface IMenuService {

    // Add a new menu item
    Menu addMenu(Menu menu);

    // Update an existing menu item
    Menu updateMenu(Long id, Menu updatedMenu);

    // Delete a menu item by ID
    void deleteMenu(Long id);

    // Fetch a menu item by ID
    Optional<Menu> getMenuById(Long id);

    // Fetch all menu items
    Iterable<Menu> getAllMenus();
}
