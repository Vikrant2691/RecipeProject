package com.recipe.RecipeProject.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    private Category category;

    @BeforeEach
    void setUp(){
        category=new Category();
    }

    @Test
    void getId() {

        Long id = 4L;

        category.setId(id);

        assertEquals(category.getId(),id);


    }

    @Test
    void getCategoryName() {
    }

    @Test
    void getRecipes() {
    }

    @Test
    void setId() {
    }

    @Test
    void setCategoryName() {
    }

    @Test
    void setRecipes() {
    }
}