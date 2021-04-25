package com.recipe.RecipeProject.repositories;

import com.recipe.RecipeProject.model.Category;
import com.recipe.RecipeProject.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {

    Optional<UnitOfMeasure> findByUom(String uom);

}
