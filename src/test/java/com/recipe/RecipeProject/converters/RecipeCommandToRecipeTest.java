package com.recipe.RecipeProject.converters;

import com.recipe.RecipeProject.command.RecipeCommand;
import com.recipe.RecipeProject.model.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCommandToRecipeTest {

    private RecipeCommand recipeCommand;

    private RecipeCommandToRecipe recipeCommandToRecipe;



    @BeforeEach
    void setUp() {

        recipeCommandToRecipe= new RecipeCommandToRecipe();
        recipeCommand= new RecipeCommand();
        recipeCommand.setId(1L);
        recipeCommand.setDescription("Description");
    }

    @Test
    void convert() {

        Recipe recipe=recipeCommandToRecipe.convert(recipeCommand);

        assertEquals(1L,recipe.getId());
        assertEquals("Description",recipe.getDescription());

    }


    @Test
    void convertIsNull() {

        Recipe recipe=recipeCommandToRecipe.convert(null);

        assertNull(recipe);

    }

    @Test
    void convertIsEmpty() {

        Recipe recipe=recipeCommandToRecipe.convert(new RecipeCommand());

        assertNotNull(recipe);

    }


}