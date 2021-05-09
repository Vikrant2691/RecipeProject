package com.recipe.RecipeProject.converters;

import com.recipe.RecipeProject.command.RecipeCommand;
import com.recipe.RecipeProject.model.Category;
import com.recipe.RecipeProject.model.Difficulty;
import com.recipe.RecipeProject.model.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeToRecipeCommandTest {

    RecipeToRecipeCommand recipeToRecipeCommand;

    @BeforeEach
    void setUp() {
        recipeToRecipeCommand = new RecipeToRecipeCommand();
    }

    @Test
    void convert() {

        Recipe sausageSpaghetti = new Recipe();
        sausageSpaghetti.setId(1L);
        sausageSpaghetti.setDescription("Easy Italian Sausage Spaghetti");
        sausageSpaghetti.setDifficulty(Difficulty.EASY);
        sausageSpaghetti.setPrepTime(3);
        sausageSpaghetti.setCookTime(4);
        sausageSpaghetti.setServings("4");
        sausageSpaghetti.setUrl("www.simplyrecipes.com");

        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(sausageSpaghetti);

        assertEquals(recipeCommand.getDescription(),sausageSpaghetti.getDescription());
    }
}