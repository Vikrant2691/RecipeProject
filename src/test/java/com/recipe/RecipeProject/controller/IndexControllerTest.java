package com.recipe.RecipeProject.controller;

import com.recipe.RecipeProject.command.RecipeCommand;
import com.recipe.RecipeProject.converters.RecipeToRecipeCommand;
import com.recipe.RecipeProject.model.*;
import com.recipe.RecipeProject.repositories.UnitOfMeasureRepository;
import com.recipe.RecipeProject.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    @Mock
    private RecipeServiceImpl recipeService;
    @Mock
    private CategoryServiceImpl categoryService;
    @Mock
    private UnitOfMeasureRepository unitOfMeasureRepository;
    @Mock
    private UpdateService updateService;
    @Mock
    private RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    Category category;


    IndexController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new IndexController(recipeService, categoryService, unitOfMeasureRepository, updateService, recipeToRecipeCommand);
    }

    @Test
    void getRecipies() {

        Recipe recipe = new Recipe();
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);

        Mockito.when(controller.getRecipes()).thenReturn(recipes);

        Set<Recipe> recipeSet = controller.getRecipes();

        assertEquals(recipeSet.size(), 1);

        Mockito.verify(recipeService).getRecipe();


    }


    @Test
    void getCategories() {


        category.setId(1L);
        category.setCategoryName("Italian");
        Set<Category> categories = new HashSet<>();
        categories.add(category);

        Mockito.when(controller.getCategories()).thenReturn(categories);

        Set<Category> categorySet = controller.getCategories();
        assertEquals(categorySet.size(), 1);
        Mockito.verify(categoryService).getCategories();

    }

    @Test
    void getUnitOFMeasures() {
    }

    @Test
    void putRecipe() {
    }

    @Test
    void addMember() {

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByUom("Each");

        if (eachUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByUom("Tablespoon");

        if (tableSpoonUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByUom("Teaspoon");

        if (teaSpoonUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByUom("Dash");

        if (dashUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByUom("Pint");

        if (pintUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByUom("Cup");

        if (cupsUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teapoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = dashUomOptional.get();
        UnitOfMeasure cupsUom = cupsUomOptional.get();

        Recipe sausageSpaghetti = new Recipe();

        Category category = categoryService.getByCategoryName("Italian");
        Set<Category> categories = new HashSet<>();
        categories.add(category);
        sausageSpaghetti.setDescription("Easy Italian Sausage Spaghetti");
        sausageSpaghetti.setCategories(categories);
        sausageSpaghetti.setDifficulty(Difficulty.EASY);
        sausageSpaghetti.setPrepTime(3);
        sausageSpaghetti.setCookTime(4);
        sausageSpaghetti.setServings("4");
        sausageSpaghetti.setUrl("www.simplyrecipes.com");
        sausageSpaghetti.setDirections("Sauté onions and garlic:\n" +
                "Heat a tablespoon of extra virgin olive oil in a large skillet on medium or medium heat. " +
                "Add the chopped onion and cook until translucent, about 5 minutes. " +
                "Add the minced garlic and cook a minute more.\n" +
                "Put pasta water on to boil:\n" +
                "While the onions are cooking, put a large pot of salted water on to boil for the pasta (4 quarts water, 2 Tbsp salt).\n" +
                "\n" +
                "Brown the sausage:\n" +
                "Remove the cooked onion and garlic from the pan and set aside. Remove the sausage meat from the casings (if your sausage is in links) and add to the pan, breaking up the meat with your fingers as you add it to the pan. Cook on medium heat until just lightly browned.\n" +
                "\n" +
                "Add tomatoes, onions, garlic:\n" +
                "Add crushed or puréed canned tomatoes with their juices to the skillet with the sausage meat. Add the cooked onions and garlic. Heat to a bare simmer.\n" +
                "\n" +
                "Boil the spaghetti pasta:\n" +
                "Once the pasta water has come to a rolling boil, add the spaghetti pasta. Allow the water to return to a rolling boil. Cook, uncovered, with a vigorous boil, for as long as the directions on the pasta package say, usually about 10-12 minutes. When pasta is al dente (cooked but still a little firm), remove the pot from the heat. Drain the pasta and place it in a serving bowl.\n" +
                "\n" +
                "Serve immediately. Toss with the sauce and garnish with grated Parmesan cheese.");

        sausageSpaghetti.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2),sausageSpaghetti, eachUom));
        sausageSpaghetti.addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"),sausageSpaghetti, teapoonUom));
        sausageSpaghetti.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2),sausageSpaghetti, tableSpoonUom));
        sausageSpaghetti.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2),sausageSpaghetti, tableSpoonUom));
        sausageSpaghetti.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2),sausageSpaghetti, eachUom));
        sausageSpaghetti.addIngredient(new Ingredient("Cilantro", new BigDecimal(2),sausageSpaghetti, tableSpoonUom));
        sausageSpaghetti.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2),sausageSpaghetti, dashUom));
        sausageSpaghetti.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"),sausageSpaghetti, eachUom));


        ResponseEntity<RecipeCommand> responseEntity = new ResponseEntity<>(
                HttpStatus.OK
        );



        Mockito.when(controller.addMember(recipeToRecipeCommand.convert(sausageSpaghetti))).thenReturn(responseEntity);


    }
}