package com.recipe.RecipeProject.repositories;

import com.recipe.RecipeProject.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe,Long> {


    @Override
    Iterable<Recipe> findAll();
}
