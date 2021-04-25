package com.recipe.RecipeProject.model;



import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String notes;

    @OneToOne
    private Recipe recipeNote;
}
