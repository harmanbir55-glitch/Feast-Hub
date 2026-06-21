package com.feasthub.service;

import com.feasthub.model.Recipe;
import com.feasthub.util.CsvUtil;
import java.util.*;

public class RecipeService {
    private static final String RECIPE_FILE = "data/recipes.csv";

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        for (String line : CsvUtil.readLines(RECIPE_FILE)) {
            String[] parts = line.split(",", 5);
            if (parts.length == 5) {
                recipes.add(new Recipe(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], Double.parseDouble(parts[4])));
            }
        }
        return recipes;
    }

    public void displayRecipes() {
        List<Recipe> recipes = getAllRecipes();
        if (recipes.isEmpty()) {
            System.out.println("No recipes found.");
            return;
        }
        for (Recipe recipe : recipes) {
            System.out.println("-----------------------------");
            System.out.println(recipe);
        }
    }

    public void searchRecipe(String keyword) {
        boolean found = false;
        for (Recipe recipe : getAllRecipes()) {
            if (recipe.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(recipe);
                found = true;
            }
        }
        if (!found) System.out.println("No matching recipe found.");
    }

    public void addRecipe(String title, String ingredients, String instructions) {
        List<Recipe> recipes = getAllRecipes();
        int nextId = recipes.size() + 1;
        Recipe recipe = new Recipe(nextId, title, ingredients, instructions, 0.0);
        List<String> lines = CsvUtil.readLines(RECIPE_FILE);
        lines.add(recipe.toCsv());
        CsvUtil.writeLines(RECIPE_FILE, lines);
        System.out.println("Recipe added successfully.");
    }

    public void rateRecipe(int id, double rating) {
        List<Recipe> recipes = getAllRecipes();
        List<String> updatedLines = new ArrayList<>();
        boolean found = false;

        for (Recipe recipe : recipes) {
            if (recipe.getId() == id) {
                recipe.updateRating(rating);
                found = true;
            }
            updatedLines.add(recipe.toCsv());
        }

        CsvUtil.writeLines(RECIPE_FILE, updatedLines);
        System.out.println(found ? "Rating updated successfully." : "Recipe ID not found.");
    }
}
