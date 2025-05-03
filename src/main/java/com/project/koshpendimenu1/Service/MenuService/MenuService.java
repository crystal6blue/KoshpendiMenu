package com.project.koshpendimenu1.Service.MenuService;

import com.project.koshpendimenu1.Model.Menu;
import com.project.koshpendimenu1.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService implements IMenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // Add a new menu item
    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    // Update an existing menu item
    @Override
    public Menu updateMenu(Long id, Menu updatedMenu) {
        if (menuRepository.existsById(id)) {
            updatedMenu.setId(id);
            return menuRepository.save(updatedMenu);
        }
        return null; // or throw an exception if the menu item does not exist
    }

    // Delete a menu item by ID
    @Override
    public void deleteMenu(Long id) {
        if (menuRepository.existsById(id)) {
            menuRepository.deleteById(id);
        }
    }

    // Fetch a menu item by ID
    @Override
    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    // Fetch all menu items
    @Override
    public Iterable<Menu> getAllMenus() {
        return menuRepository.findAll();
    }
}
