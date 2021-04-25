package com.recipe.RecipeProject.repositories;

import com.recipe.RecipeProject.model.Category;
import com.recipe.RecipeProject.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByCategoryName(String categoryNamesblah);

}
