package com.recipe.RecipeProject.controller;

import com.recipe.RecipeProject.command.RecipeCommand;
import com.recipe.RecipeProject.converters.RecipeToRecipeCommand;
import com.recipe.RecipeProject.model.Category;
import com.recipe.RecipeProject.model.Ingredient;
import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.repositories.UnitOfMeasureRepository;
import com.recipe.RecipeProject.services.CategoryServiceImpl;
import com.recipe.RecipeProject.services.RecipeServiceImpl;
import com.recipe.RecipeProject.services.UpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@Slf4j
@CrossOrigin
public class IndexController {

    private final RecipeServiceImpl recipeService;
    private final CategoryServiceImpl categoryService;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UpdateService updateService;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public IndexController(RecipeServiceImpl recipeService, CategoryServiceImpl categoryService, UnitOfMeasureRepository unitOfMeasureRepository, UpdateService updateService, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.updateService = updateService;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @GetMapping(path = "/getrecipes")
    Set<Recipe> getRecipes() {


        return recipeService.getRecipe();
    }


    @GetMapping(path = "/getrecipe/{id}")
    RecipeCommand getRecipe(@PathVariable Long id) {

        return recipeService.findById(id);
    }

    @GetMapping(path = "/getcategories")
    Set<Category> getCategories() {

        return categoryService.getCategories();


    }

    @GetMapping(path = "/getrecipe/{recipeId}/ingredients")
    Set<Ingredient> getIngredients(@PathVariable("recipeId") Long recipeId) {

        return recipeService.getIngredients(recipeId);


    }

    @GetMapping(path = "/getrecipe/{recipeId}/ingredient/{ingredientId}")
    Ingredient getIngredient(@PathVariable("recipeId") Long recipeId, @PathVariable("ingredientId") Long ingredientId) {

        return recipeService.getIngredient(recipeId,ingredientId);


    }

    @GetMapping(path = "/getrecipe/{recipeId}/ingredient/{ingredientId}/update")
    Ingredient updateIngredient(@PathVariable("recipeId") Long recipeId, @PathVariable("ingredientId") Long ingredientId, Ingredient ingredient) {

        return updateService.updateIngredient(recipeId,ingredientId,ingredient);


    }

    @GetMapping(path = "/getuom")
    Iterable<Recipe> getUnitOFMeasures() {

        return recipeService.getRecipe();


    }


    @PatchMapping(path = "/updaterecipe/{id}", consumes = "application/json")
    public ResponseEntity<RecipeCommand> putRecipe(@RequestBody Recipe recipe, @PathVariable("id") Long id) {

        RecipeCommand currentRecipe = recipeService.findById(id);
        if (currentRecipe == null)
            return ResponseEntity.notFound().build();

        updateService.updateRecipe(recipe, id);


        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/saverecipes", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RecipeCommand> addMember(@RequestBody RecipeCommand recipeCommand) {
        recipeService.save(recipeCommand);

        return ResponseEntity.ok().build();
    }

}
