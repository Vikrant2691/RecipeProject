package com.recipe.RecipeProject.services;

import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.repositories.RecipeRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Set<Recipe> getRecipe() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }
}
