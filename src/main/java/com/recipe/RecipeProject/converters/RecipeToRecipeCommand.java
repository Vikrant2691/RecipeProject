package com.recipe.RecipeProject.converters;

import com.recipe.RecipeProject.command.RecipeCommand;
import com.recipe.RecipeProject.model.Recipe;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {


    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {
        if (recipe == null)
            return null;

        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(recipe.getId());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setUrl(recipe.getUrl());
        recipeCommand.setDirections(recipe.getDirections());
        recipeCommand.setImage(recipe.getImage());
        recipeCommand.setNotes(recipe.getNotes());
        recipeCommand.setDifficulty(recipe.getDifficulty());


        if (recipe.getIngredients() != null && recipe.getIngredients().size() > 0)
            recipe.getIngredients().forEach(ingredient -> recipeCommand.getIngredients().add(ingredient));

        if (recipe.getCategories() != null && recipe.getCategories().size() > 0)
            recipe.getCategories().forEach(category -> recipeCommand.getCategories().add(category));

        log.info(recipeCommand.getDirections());
        return recipeCommand;
    }
}
