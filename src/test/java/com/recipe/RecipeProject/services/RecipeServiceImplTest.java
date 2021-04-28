package com.recipe.RecipeProject.services;

import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceImplTest {

    private RecipeService recipeService;
    @Mock
    private RecipeRepository recipeRepository;


    @BeforeEach
    void setUp() {
        recipeService= new RecipeServiceImpl(recipeRepository);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getRec() {

        Recipe recipe = new Recipe();
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        Mockito.when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes= (Set<Recipe>) recipeRepository.findAll();


        assertEquals(recipes.size(),1);
        Mockito.verify(recipeRepository,Mockito.times(1)).findAll();

    }
}