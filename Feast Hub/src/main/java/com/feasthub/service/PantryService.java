package com.feasthub.service;

import com.feasthub.model.Ingredient;
import com.feasthub.model.Recipe;
import com.feasthub.util.CsvUtil;
import java.util.*;
import java.util.stream.Collectors;

public class PantryService {
    private static final String PANTRY_FILE = "data/pantry.csv";

    public List<Ingredient> getPantryItems() {
        List<Ingredient> items = new ArrayList<>();
        for (String line : CsvUtil.readLines(PANTRY_FILE)) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                items.add(new Ingredient(parts[0], Integer.parseInt(parts[1]), parts[2]));
            }
        }
        return items;
    }

    public void displayPantry() {
        for (Ingredient item : getPantryItems()) {
            System.out.println(item);
        }
    }

    public void addPantryItem(String name, int quantity, String expiryDate) {
        List<String> lines = CsvUtil.readLines(PANTRY_FILE);
        lines.add(name + "," + quantity + "," + expiryDate);
        CsvUtil.writeLines(PANTRY_FILE, lines);
        System.out.println("Pantry item added successfully.");
    }

    public void suggestRecipes(List<Recipe> recipes) {
        Set<String> pantryNames = getPantryItems().stream()
                .map(item -> item.getName().toLowerCase())
                .collect(Collectors.toSet());

        System.out.println("Recipes matching your pantry:");
        boolean found = false;
        for (Recipe recipe : recipes) {
            long matched = recipe.getIngredients().stream()
                    .filter(ingredient -> pantryNames.contains(ingredient.trim().toLowerCase()))
                    .count();
            if (matched > 0) {
                System.out.println(recipe.getTitle() + " - matched ingredients: " + matched);
                found = true;
            }
        }
        if (!found) System.out.println("No pantry-based recipe suggestions found.");
    }
}
