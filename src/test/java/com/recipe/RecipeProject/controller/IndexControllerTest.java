package com.recipe.RecipeProject.controller;

import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.repositories.CategoryRepository;
import com.recipe.RecipeProject.repositories.RecipeRepository;
import com.recipe.RecipeProject.repositories.UnitOfMeasureRepository;
import com.recipe.RecipeProject.services.CategoryServiceImpl;
import com.recipe.RecipeProject.services.RecipeService;
import com.recipe.RecipeProject.services.UnitOfMeasureServiceImpl;
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
    private RecipeRepository recipeRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private UnitOfMeasureRepository unitOfMeasureRepository;

IndexController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller= new IndexController(recipeRepository, categoryRepository, unitOfMeasureRepository);
    }

    @Test
    void getRecipies() {

        Recipe recipe = new Recipe();
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);

        Mockito.when(controller.getRecipies()).thenReturn(recipes);

        Set<Recipe> recipeSet = (Set<Recipe>) controller.getRecipies();

        assertEquals(recipeSet.size(),1);

        Mockito.verify(recipeRepository,Mockito.times(1)).findAll();



    }
}