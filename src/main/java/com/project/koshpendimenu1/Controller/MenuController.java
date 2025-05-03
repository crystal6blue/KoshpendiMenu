package com.project.koshpendimenu1.Controller;

import com.project.koshpendimenu1.Model.Menu;
import com.project.koshpendimenu1.Service.MenuService.IMenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final IMenuService menuService;

    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }

    // Add a new menu item
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addMenu(@RequestBody Menu menu) {
        menuService.addMenu(menu);
        return ResponseEntity.ok("Successfully created");
    }

    // Get a menu item by ID
    @GetMapping("/{id}")
    public Optional<Menu> getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    // Get all menu items
    @GetMapping
    public Iterable<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    // Update an existing menu item
    @PutMapping("/{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody Menu updatedMenu) {
        return menuService.updateMenu(id, updatedMenu);
    }

    // Delete a menu item by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}
