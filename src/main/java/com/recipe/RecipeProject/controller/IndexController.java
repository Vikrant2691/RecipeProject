package com.recipe.RecipeProject.controller;

import com.recipe.RecipeProject.model.Category;
import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.repositories.CategoryRepository;
import com.recipe.RecipeProject.repositories.RecipeRepository;
import com.recipe.RecipeProject.repositories.UnitOfMeasureRepository;
import com.recipe.RecipeProject.services.CategoryServiceImpl;
import com.recipe.RecipeProject.services.RecipeService;
import com.recipe.RecipeProject.services.UnitOfMeasureServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;


@RestController
@Slf4j
@CrossOrigin
public class IndexController {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @GetMapping(path = "/getrecipes")
    Set<Recipe> getRecipies() {

        Set<Recipe> recipes = new HashSet<>();

        recipeRepository.findAll().forEach(recipes::add);
        return recipes;


    }

    @GetMapping(path = "/getcategories")
    Iterable<Category> getCategories() {

        return categoryRepository.findAll();


    }

    @GetMapping(path = "/getuom")
    Iterable<Recipe> getUnitOFMeasures() {

        return recipeRepository.findAll();


    }

}
