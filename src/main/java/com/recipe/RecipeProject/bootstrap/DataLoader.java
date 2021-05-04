package com.recipe.RecipeProject.bootstrap;

import com.recipe.RecipeProject.model.*;
import com.recipe.RecipeProject.repositories.CategoryRepository;
import com.recipe.RecipeProject.repositories.RecipeRepository;
import com.recipe.RecipeProject.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {


    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;


    public DataLoader(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Recipe recipe = new Recipe();

        Category category = categoryRepository.findByCategoryName("Italian").orElse(null);
        Set<Category> categories = new HashSet<>();
        categories.add(category);
        recipe.setDescription("Easy Italian Sausage Spaghetti");
        recipe.setCategories(categories);
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setPrepTime(3);
        recipe.setCookTime(4);
        recipe.setServings("4");
        recipe.setUrl("www.simplyrecipes.com");
        recipe.setDirections("Sauté onions and garlic:\n" +
                        "Heat a tablespoon of extra virgin olive oil in a large skillet on medium or medium heat. " +
                        "Add the chopped onion and cook until translucent, about 5 minutes. " +
                        "Add the minced garlic and cook a minute more.\n" +
                        "Put pasta water on to boil:\n" +
                        "While the onions are cooking, put a large pot of salted water on to boil for the pasta (4 quarts water, 2 Tbsp salt).\n" +
                        "\n" +
                        "Brown the sausage:\n" +
                        "Remove the cooked onion and garlic from the pan and set aside. Remove the sausage meat from the casings (if your sausage is in links) and add to the pan, breaking up the meat with your fingers as you add it to the pan. Cook on medium heat until just lightly browned.\n" +
                        "\n" +
                        "Add tomatoes, onions, garlic:\n" +
                        "Add crushed or puréed canned tomatoes with their juices to the skillet with the sausage meat. Add the cooked onions and garlic. Heat to a bare simmer.\n" +
                        "\n" +
                        "Boil the spaghetti pasta:\n" +
                        "Once the pasta water has come to a rolling boil, add the spaghetti pasta. Allow the water to return to a rolling boil. Cook, uncovered, with a vigorous boil, for as long as the directions on the pasta package say, usually about 10-12 minutes. When pasta is al dente (cooked but still a little firm), remove the pot from the heat. Drain the pasta and place it in a serving bowl.\n" +
                        "\n" +
                        "Serve immediately. Toss with the sauce and garnish with grated Parmesan cheese.");

       Ingredient ingredient = new Ingredient();
        ingredient.setDescription("1 tablespoon extra virgin olive oil");
        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findByUom("Tablespoon").orElse(null);
        ingredient.setUnitOfMeasure(unitOfMeasure);

        recipe=recipe.addIngredient(ingredient);

        recipeRepository.save(recipe);

        Set<Recipe> recipes = new HashSet<>();

        recipeRepository.findAll().forEach(recipes::add);

recipes.forEach(recipe1-> System.out.println(recipe1.getDescription()));
    }
}
