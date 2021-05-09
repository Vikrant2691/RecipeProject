package com.recipe.RecipeProject.services;

import com.recipe.RecipeProject.model.UnitOfMeasure;

import java.util.Optional;
import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasure> getUnitOfMeasure();

    UnitOfMeasure getUnitOfMeasureByDescription();

    Optional<UnitOfMeasure> findByDescription(String description);

    Optional<UnitOfMeasure> findById(Long Id);
}
