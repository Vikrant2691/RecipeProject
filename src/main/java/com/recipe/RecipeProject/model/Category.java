package com.recipe.RecipeProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String categoryName;

    @ManyToMany( mappedBy = "categories")
    @JsonBackReference
    private Set<Recipe> recipes = new HashSet<>();

}
