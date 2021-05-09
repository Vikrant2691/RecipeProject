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
import java.util.Optional;
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

        Optional<Recipe> recipeCommandOptional = recipeRepository.findById(aLong);

        if (recipeCommandOptional.isPresent())
            throw new RuntimeException("Recipe not found");

        return recipeToRecipeCommand.convert(recipeCommandOptional.get());

    }

    @Override
    public Set<Ingredient> getIngredients(Long aLong) {
        return recipeRepository.findById(aLong).orElse(null).getIngredients();
    }

    @Override
    public Ingredient getIngredient(Long recipeId, Long ingredientId) {
        return getIngredients(recipeId)
                .stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public RecipeCommand save(RecipeCommand recipeCommand) {
        Recipe recipeToBeSaved = Objects.requireNonNull(recipeCommandToRecipe.convert(recipeCommand));
        Recipe recipeSaved = recipeRepository.save(recipeToBeSaved);


        return recipeToRecipeCommand.convert(recipeSaved);
    }

    @Override
    public void deleteById(Long idToDelete) {

    }

}
