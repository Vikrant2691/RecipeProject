package com.recipe.RecipeProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String description;
    private BigDecimal amount;

    @ManyToOne
    @JsonBackReference
    private Recipe recipe;

    @OneToOne
    private UnitOfMeasure unitOfMeasure;

}
