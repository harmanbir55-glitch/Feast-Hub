package com.feasthub.model;

import java.util.Arrays;
import java.util.List;

public class Recipe {
    private int id;
    private String title;
    private List<String> ingredients;
    private String instructions;
    private double rating;

    public Recipe(int id, String title, String ingredientText, String instructions, double rating) {
        this.id = id;
        this.title = title;
        this.ingredients = Arrays.asList(ingredientText.split("\\|"));
        this.instructions = instructions;
        this.rating = rating;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public List<String> getIngredients() { return ingredients; }
    public String getInstructions() { return instructions; }
    public double getRating() { return rating; }

    public void updateRating(double newRating) {
        this.rating = (this.rating + newRating) / 2.0;
    }

    public String toCsv() {
        return id + "," + title + "," + String.join("|", ingredients) + "," + instructions + "," + rating;
    }

    @Override
    public String toString() {
        return "#" + id + " " + title + "\nIngredients: " + ingredients +
                "\nInstructions: " + instructions + "\nRating: " + String.format("%.1f", rating);
    }
}
