package com.recipe.RecipeProject.converters;

import com.recipe.RecipeProject.command.RecipeCommand;
import com.recipe.RecipeProject.model.Recipe;
import org.springframework.core.convert.converter.Converter;

public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {


    @Override
    public RecipeCommand convert(Recipe recipe) {
        if (recipe == null)
            return null;

        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(recipeCommand.getId());
        recipeCommand.setDescription(recipeCommand.getDescription());
        recipeCommand.setPrepTime(recipeCommand.getPrepTime());
        recipeCommand.setCookTime(recipeCommand.getCookTime());
        recipeCommand.setServings(recipeCommand.getServings());
        recipeCommand.setSource(recipeCommand.getSource());
        recipeCommand.setUrl(recipeCommand.getUrl());
        recipeCommand.setDirections(recipeCommand.getDirections());
        recipeCommand.setImage(recipeCommand.getImage());
        recipeCommand.setNotes(recipeCommand.getNotes());
        recipeCommand.setDifficulty(recipeCommand.getDifficulty());


        if (recipeCommand.getIngredients() != null && recipeCommand.getIngredients().size() > 0)
            recipe.getIngredients().forEach(ingredient -> recipeCommand.getIngredients().add(ingredient));

        if (recipeCommand.getCategories() != null && recipeCommand.getCategories().size() > 0)
            recipe.getCategories().forEach(category -> recipeCommand.getCategories().add(category));


        return recipeCommand;
    }
}
