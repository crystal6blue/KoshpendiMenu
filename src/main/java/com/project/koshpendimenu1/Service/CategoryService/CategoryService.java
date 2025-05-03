package com.project.koshpendimenu1.Service.CategoryService;

import com.project.koshpendimenu1.Model.Category;
import com.project.koshpendimenu1.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);  // Return null if category not found
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();  // Retrieve all categories from the database
    }
}
