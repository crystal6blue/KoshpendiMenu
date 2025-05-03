package com.project.koshpendimenu1.Service.CategoryService;

import com.project.koshpendimenu1.Model.Category;
import com.project.koshpendimenu1.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    public final CategoryRepository categoryRepository;

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .get();
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}
