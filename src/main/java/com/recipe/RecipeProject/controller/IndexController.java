package com.recipe.RecipeProject.controller;

import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class IndexController {

    private final RecipeService recipeService;

    public IndexController( RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(path = "/getrecipes")
    Iterable<Recipe> getRecipies() {

        return recipeService.getRec();


    }

}
