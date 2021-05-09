package com.recipe.RecipeProject.services;

import com.recipe.RecipeProject.model.Category;
import com.recipe.RecipeProject.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Set<Category> getCategories() {

        Set<Category> categories= new HashSet<>();
        categoryRepository.findAll().forEach(categories::add);

        return categories;
    }

    public Category getByCategoryName(String categoryName){
        return categoryRepository.findByCategoryName(categoryName).orElse(null);
    }

}
