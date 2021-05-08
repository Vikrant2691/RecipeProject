package com.recipe.RecipeProject.services;


import com.recipe.RecipeProject.model.Recipe;
import com.recipe.RecipeProject.repositories.RecipeRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateService {


    private final RecipeRepository recipeRepository;

    public UpdateService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public boolean updateRecipe(Recipe updates, Long id) {

        Recipe recipe = recipeRepository.findById(id).orElse(null);
        if (recipe == null)
            return false;

        
        if(!(updates.getDescription() == null || updates.getDescription().equals("")))  recipe.setDescription(updates.getDescription());
        if(!(updates.getPrepTime() == null))  recipe.setPrepTime(updates.getPrepTime());
        if(!(updates.getCookTime() == null))  recipe.setPrepTime(updates.getCookTime());
        if(!(updates.getServings() == null || updates.getServings().equals("")))  recipe.setServings(updates.getServings());
        if(!(updates.getSource() == null || updates.getSource().equals("")))  recipe.setSource(updates.getSource());
        if(!(updates.getUrl() == null || updates.getUrl().equals("")))  recipe.setUrl(updates.getUrl());
        if(!(updates.getImage()== null))  recipe.setImage(updates.getImage());
        if(!(updates.getIngredients().isEmpty()))  recipe.getIngredients().addAll(updates.getIngredients());
        if(!(updates.getNotes()== null)) recipe.setNotes(updates.getNotes());
        if(!(updates.getDifficulty()== null)) recipe.setDifficulty(updates.getDifficulty());
        if(!(updates.getDirections()== null)) recipe.setDirections(updates.getDirections());

        if(updates.getIngredients()!=null && updates.getIngredients().size()>0){
            updates.getIngredients().forEach(ingredient -> recipe.getIngredients().add(ingredient));
        }

        if(updates.getCategories()!=null && updates.getCategories().size()>0){
            updates.getCategories().forEach(ingredient -> recipe.getCategories().add(ingredient));
        }



        recipeRepository.save(recipe);

        return true;

    }

}
