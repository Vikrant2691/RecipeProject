package com.recipe.RecipeProject.services;

import com.recipe.RecipeProject.command.RecipeCommand;
import com.recipe.RecipeProject.model.Ingredient;
import com.recipe.RecipeProject.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipe();

    RecipeCommand findById(Long aLong);

    Set<Ingredient> getIngredient(Long aLong);

    RecipeCommand save(RecipeCommand recipeCommand);

    void deleteById(Long idToDelete);
}
