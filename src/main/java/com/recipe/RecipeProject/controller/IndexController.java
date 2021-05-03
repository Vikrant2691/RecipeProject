package com.recipe.RecipeProject.controller;

import com.recipe.RecipeProject.model.Category;
import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.services.CategoryService;
import com.recipe.RecipeProject.services.RecipeService;
import com.recipe.RecipeProject.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@Slf4j
public class IndexController {

    private final RecipeService recipeService;
    private final CategoryService categoryService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IndexController(RecipeService recipeService, CategoryService categoryService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping(path = "/getrecipes")
    Iterable<Recipe> getRecipies() {

        return recipeService.getRecipe();


    }

    @GetMapping(path = "/getcategories")
    Set<Category> getCategories() {

        return categoryService.getCategories();


    }

    @GetMapping(path = "/getuom")
    Iterable<Recipe> getUnitOFMeasures() {

        return recipeService.getRecipe();


    }

}
