package com.project.koshpendimenu1.Service.CategoryService;

import com.project.koshpendimenu1.Model.Category;

import java.util.List;

public interface ICategoryService {

    // Find a category by its ID
    Category findCategoryById(Long id);

    // Get all categories
    List<Category> findAllCategories();
}
