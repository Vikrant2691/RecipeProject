package com.recipe.RecipeProject.converters;

import com.recipe.RecipeProject.command.RecipeCommand;
import com.recipe.RecipeProject.model.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {
        if(recipeCommand==null)
            return null;

        final Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setServings(recipeCommand.getServings());
        recipe.setSource(recipeCommand.getSource());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setImage(recipeCommand.getImage());
        recipe.setIngredients(recipeCommand.getIngredients());
        recipe.setNotes(recipeCommand.getNotes());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setCategories(recipeCommand.getCategories());

        return recipe;
    }
}
