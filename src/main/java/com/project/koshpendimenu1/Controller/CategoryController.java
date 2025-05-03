package com.project.koshpendimenu1.Controller;

import com.project.koshpendimenu1.Model.Category;
import com.project.koshpendimenu1.Service.CategoryService.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAllCategories();
    }

    // Fetch a category by ID
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return Optional.ofNullable(categoryService.findCategoryById(id));
    }
}
