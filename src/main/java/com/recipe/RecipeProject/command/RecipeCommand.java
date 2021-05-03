package com.recipe.RecipeProject.command;


import com.recipe.RecipeProject.model.Category;
import com.recipe.RecipeProject.model.Difficulty;
import com.recipe.RecipeProject.model.Ingredient;
import com.recipe.RecipeProject.model.Notes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private String servings;
    private String source;
    private String url;
    private String directions;
    private Byte[] image;
    private final Set<Ingredient> ingredients = new HashSet<>();
    private Notes notes;
    private Difficulty difficulty;
    private final Set<Category> categories = new HashSet<>();

}
