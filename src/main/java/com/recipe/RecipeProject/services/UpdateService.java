package com.recipe.RecipeProject.services;


import com.recipe.RecipeProject.model.Ingredient;
import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.repositories.RecipeRepository;
import com.recipe.RecipeProject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateService {


    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UpdateService(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    public boolean updateRecipe(Recipe updates, Long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isPresent())
            throw new RuntimeException("Recipe not found");
        Recipe recipe = recipeOptional.get();

        if (!(updates.getDescription() == null || updates.getDescription().equals("")))
            recipe.setDescription(updates.getDescription());
        if (!(updates.getPrepTime() == null)) recipe.setPrepTime(updates.getPrepTime());
        if (!(updates.getCookTime() == null)) recipe.setPrepTime(updates.getCookTime());
        if (!(updates.getServings() == null || updates.getServings().equals("")))
            recipe.setServings(updates.getServings());
        if (!(updates.getSource() == null || updates.getSource().equals(""))) recipe.setSource(updates.getSource());
        if (!(updates.getUrl() == null || updates.getUrl().equals(""))) recipe.setUrl(updates.getUrl());
        if (!(updates.getImage() == null)) recipe.setImage(updates.getImage());
        if (!(updates.getIngredients().isEmpty())) recipe.getIngredients().addAll(updates.getIngredients());
        if (!(updates.getNotes() == null)) recipe.setNotes(updates.getNotes());
        if (!(updates.getDifficulty() == null)) recipe.setDifficulty(updates.getDifficulty());
        if (!(updates.getDirections() == null)) recipe.setDirections(updates.getDirections());

        if (updates.getIngredients() != null && updates.getIngredients().size() > 0) {
            updates.getIngredients().forEach(ingredient -> recipe.getIngredients().add(ingredient));
        }

        if (updates.getCategories() != null && updates.getCategories().size() > 0) {
            updates.getCategories().forEach(ingredient -> recipe.getCategories().add(ingredient));
        }


        recipeRepository.save(recipe);

        return true;

    }

    public Ingredient updateIngredient(Long recipeId, Long ingredientId, Ingredient providedIngredient) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if (recipeOptional.isPresent())
            throw new RuntimeException("Recipe not found");

        Recipe recipe = recipeOptional.get();

        Ingredient ingredient = recipe.getIngredients()
                .stream()
                .filter(i -> i.getId().equals(ingredientId))
                .findFirst().orElse(null);

        if (ingredient == null) {
            recipe.addIngredient(ingredient);
        } else {
            if (!(providedIngredient.getDescription() == null || providedIngredient.getDescription().equals("")))
                ingredient.setDescription(providedIngredient.getDescription());
            if (!(providedIngredient.getAmount() == null))
                ingredient.setAmount(providedIngredient.getAmount());
            if (!(providedIngredient.getUnitOfMeasure() == null))
                ingredient.setUnitOfMeasure(unitOfMeasureRepository
                        .findById(providedIngredient.getUnitOfMeasure().getId())
                        .orElseThrow(() -> new RuntimeException("UOM not found")));
            else
                throw new RuntimeException("Unit Of Measure not found");
            recipe.addIngredient(ingredient);
        }

        return ingredient;
    }

}
