package com.recipe.RecipeProject.services;

import com.recipe.RecipeProject.command.RecipeCommand;
import com.recipe.RecipeProject.converters.RecipeCommandToRecipe;
import com.recipe.RecipeProject.converters.RecipeToRecipeCommand;
import com.recipe.RecipeProject.model.Ingredient;
import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
    private final RecipeCommandToRecipe recipeCommandToRecipe;


    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeToRecipeCommand recipeToRecipeCommand, RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeRepository = recipeRepository;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }


    @Override
    public Set<Recipe> getRecipe() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public RecipeCommand findById(Long aLong) {

        return recipeToRecipeCommand.convert(Objects.requireNonNull(recipeRepository.findById(aLong).orElse(null)));
//        return recipeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Ingredient> getIngredient(Long aLong) {
        return recipeRepository.findById(aLong).orElse(null).getIngredients();
    }

    @Override
    public RecipeCommand save(RecipeCommand recipeCommand) {
        return null;
    }

    @Override
    public void deleteById(Long idToDelete) {

    }

}
