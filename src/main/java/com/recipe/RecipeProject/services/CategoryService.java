package com.recipe.RecipeProject.services;

import com.recipe.RecipeProject.model.Category;
import com.recipe.RecipeProject.repositories.CategoryRepository;

import java.util.HashSet;
import java.util.Set;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Set<Category> getCategories() {

        Set<Category> categories= new HashSet<>();
        categoryRepository.findAll().forEach(categories::add);

        return categories;
    }

}
