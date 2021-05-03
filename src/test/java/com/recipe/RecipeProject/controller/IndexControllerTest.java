package com.recipe.RecipeProject.controller;

import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.services.CategoryService;
import com.recipe.RecipeProject.services.RecipeService;
import com.recipe.RecipeProject.services.UnitOfMeasureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    @Mock
    private RecipeService recipeService;
    @Mock
    private CategoryService categoryService;
    @Mock
    private UnitOfMeasureService unitOfMeasureService;

IndexController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller= new IndexController(recipeService, categoryService, unitOfMeasureService);
    }

    @Test
    void getRecipies() {

        Recipe recipe = new Recipe();
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);

        Mockito.when(controller.getRecipies()).thenReturn(recipes);

        Set<Recipe> recipeSet = (Set<Recipe>) controller.getRecipies();

        assertEquals(recipeSet.size(),1);

        Mockito.verify(recipeService,Mockito.times(1)).getRecipe();



    }
}