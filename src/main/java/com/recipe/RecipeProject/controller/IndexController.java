package com.recipe.RecipeProject.controller;

import com.recipe.RecipeProject.model.Category;
import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.model.UnitOfMeasure;
import com.recipe.RecipeProject.repositories.CategoryRepository;
import com.recipe.RecipeProject.repositories.RecipeRepository;
import com.recipe.RecipeProject.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasure;
    private final RecipeRepository recipeRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasure, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasure = unitOfMeasure;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping(path = "/getCategories")
    String getCategory() {
        Optional<Category> category = categoryRepository.findByCategoryName("American");
        Optional<UnitOfMeasure> unit = unitOfMeasure.findByUom("Teaspoon");
        System.out.println("Cat is:" + category.get().getId());
        System.out.println("UOM is:" + unit.get().getId());

        return "yo";


    }

    @GetMapping(path = "/getrecipes")
    Iterable<Recipe> getRecipies() {

        return recipeRepository.findAll();


    }

}
