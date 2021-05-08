package com.recipe.RecipeProject.bootstrap;

import com.recipe.RecipeProject.converters.RecipeToRecipeCommand;
import com.recipe.RecipeProject.model.*;
import com.recipe.RecipeProject.repositories.UnitOfMeasureRepository;
import com.recipe.RecipeProject.services.CategoryServiceImpl;
import com.recipe.RecipeProject.services.RecipeServiceImpl;
import com.recipe.RecipeProject.services.UnitOfMeasureServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {


    private final CategoryServiceImpl categoryService;
    private final RecipeServiceImpl recipeService;
    private final UnitOfMeasureServiceImpl unitOfMeasureService;
    private final RecipeToRecipeCommand recipeToRecipeCommand;


    public DataLoader(CategoryServiceImpl categoryService, RecipeServiceImpl recipeService, UnitOfMeasureServiceImpl unitOfMeasureService, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.categoryService = categoryService;
        this.recipeService = recipeService;
        this.unitOfMeasureService = unitOfMeasureService;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }


    @Override
    public void run(String... args) throws Exception {

        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureService.findByDescription("Each");

        if (eachUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureService.findByDescription("Tablespoon");

        if (tableSpoonUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureService.findByDescription("Teaspoon");

        if (teaSpoonUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureService.findByDescription("Dash");

        if (dashUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureService.findByDescription("Pint");

        if (pintUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureService.findByDescription("Cup");

        if (cupsUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teapoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = dashUomOptional.get();
        UnitOfMeasure cupsUom = cupsUomOptional.get();


        Recipe sausageSpaghetti = new Recipe();

        Category category = categoryService.getByCategoryName("Italian");
        Set<Category> categories = new HashSet<>();
        categories.add(category);
        sausageSpaghetti.setDescription("Easy Italian Sausage Spaghetti");
        sausageSpaghetti.setCategories(categories);
        sausageSpaghetti.setDifficulty(Difficulty.EASY);
        sausageSpaghetti.setPrepTime(3);
        sausageSpaghetti.setCookTime(4);
        sausageSpaghetti.setServings("4");
        sausageSpaghetti.setUrl("www.simplyrecipes.com");
        sausageSpaghetti.setDirections("Sauté onions and garlic:\n" +
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

        Notes sausageSpaghettiNotes = new Notes();
        sausageSpaghettiNotes.setNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");

        sausageSpaghetti.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), sausageSpaghetti, eachUom));
        sausageSpaghetti.addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"), sausageSpaghetti, teapoonUom));
        sausageSpaghetti.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), sausageSpaghetti, tableSpoonUom));
        sausageSpaghetti.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), sausageSpaghetti, tableSpoonUom));
        sausageSpaghetti.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), sausageSpaghetti, eachUom));
        sausageSpaghetti.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), sausageSpaghetti, tableSpoonUom));
        sausageSpaghetti.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), sausageSpaghetti, dashUom));
        sausageSpaghetti.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), sausageSpaghetti, eachUom));

        recipeService.save(recipeToRecipeCommand.convert(sausageSpaghetti));


        Recipe ovenRoastedSalmon = new Recipe();

        Category oRSCategory = categoryService.getByCategoryName("American");
        Set<Category> oRSCategoryCategories = new HashSet<>();
        categories.add(oRSCategory);
        ovenRoastedSalmon.setDescription("Oven-Roasted Salmon, Asparagus and New Potatoes");
        ovenRoastedSalmon.setCategories(oRSCategoryCategories);
        ovenRoastedSalmon.setDifficulty(Difficulty.MODERATE);
        ovenRoastedSalmon.setPrepTime(4);
        ovenRoastedSalmon.setCookTime(5);

        ovenRoastedSalmon.setServings("5");
        ovenRoastedSalmon.setUrl("www.simplyrecipes.com");
        ovenRoastedSalmon.setDirections("Roast the potatoes:\n" +
                "Preheat oven to 400°F (205°C). In a sheet pan, or a large, shallow roasting pan (not glass, as it might break in an oven that hot) toss the potatoes with olive oil and sprinkle all over with salt.\n" +
                "\n" +
                "Place the potatoes cut side down in the roasting pan and cook for 10-12 minutes, until the potatoes begin to brown on the bottom.\n" +
                "Toss asparagus with dill, zest, garlic, salt, olive oil, and mix with potatoes:\n" +
                "In a medium bowl, toss the asparagus with the chopped dill, lemon zest, garlic, about 1/2 teaspoon of salt and a little olive oil. Add the asparagus mixture to the potatoes and stir to combine.\n" +
                "Make room for salmon fillets in the pan, and roast:\n" +
                "Push the vegetables to the side of the dish to make room for the salmon. If you are using fillets, put them skin side down. Salt the salmon well and return the baking dish to the oven.\n" +
                "Roast the salmon and asparagus for 10 minutes, or until the fish is just cooked through.\n" +
                "\n" +
                "If you want, remove the skin and center bones (if you are using steaks), and arrange on individual plates before serving. Garnish with fresh dill and lemon wedges.");


        ovenRoastedSalmon.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), ovenRoastedSalmon, tableSpoonUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), ovenRoastedSalmon, teapoonUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), ovenRoastedSalmon, teapoonUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("Sugar", new BigDecimal(1), ovenRoastedSalmon, teapoonUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("Salt", new BigDecimal(".5"), ovenRoastedSalmon, teapoonUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), ovenRoastedSalmon, eachUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), ovenRoastedSalmon, tableSpoonUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), ovenRoastedSalmon, tableSpoonUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), ovenRoastedSalmon, tableSpoonUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), ovenRoastedSalmon, tableSpoonUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8), ovenRoastedSalmon, eachUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), ovenRoastedSalmon, cupsUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), ovenRoastedSalmon, eachUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), ovenRoastedSalmon, eachUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), ovenRoastedSalmon, pintUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), ovenRoastedSalmon, eachUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), ovenRoastedSalmon, eachUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), ovenRoastedSalmon, cupsUom));
        ovenRoastedSalmon.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), ovenRoastedSalmon, eachUom));

        recipeService.save(recipeToRecipeCommand.convert(ovenRoastedSalmon));

    }
}
