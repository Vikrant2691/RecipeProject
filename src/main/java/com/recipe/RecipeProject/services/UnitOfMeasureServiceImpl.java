package com.recipe.RecipeProject.services;

import com.recipe.RecipeProject.model.UnitOfMeasure;
import com.recipe.RecipeProject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @Override
    public Set<UnitOfMeasure> getUnitOfMeasure() {
        return null;
    }
    @Override
    public UnitOfMeasure getUnitOfMeasureByDescription() {
        return null;
    }

    @Override
    public Optional<UnitOfMeasure> findByDescription(String description) {
        return unitOfMeasureRepository.findByUom(description);

    }

    @Override
    public Optional<UnitOfMeasure> findById(Long Id) {
        return unitOfMeasureRepository.findById(Id);
    }

}
