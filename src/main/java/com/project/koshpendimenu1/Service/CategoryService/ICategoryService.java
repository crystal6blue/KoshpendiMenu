package com.project.koshpendimenu1.Service.CategoryService;


import com.project.koshpendimenu1.Model.Category;

import java.util.List;

public interface ICategoryService {

    public Category findCategoryById(Long id);

    public List<Category> findAllCategories();
}
