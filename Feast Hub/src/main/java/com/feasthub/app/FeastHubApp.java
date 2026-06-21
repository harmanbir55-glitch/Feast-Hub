package com.feasthub.app;

import com.feasthub.service.*;
import com.feasthub.util.InputValidator;
import java.util.Scanner;

public class FeastHubApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RecipeService recipeService = new RecipeService();
    private static final PantryService pantryService = new PantryService();
    private static final SupportLogService supportLogService = new SupportLogService();
    private static final BackupService backupService = new BackupService();

    public static void main(String[] args) {
        System.out.println("Welcome to Feast-Hub");
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": recipeService.displayRecipes(); break;
                case "2": searchRecipe(); break;
                case "3": addRecipe(); break;
                case "4": rateRecipe(); break;
                case "5": pantryService.displayPantry(); break;
                case "6": addPantryItem(); break;
                case "7": pantryService.suggestRecipes(recipeService.getAllRecipes()); break;
                case "8": supportLogService.displayLogs(); break;
                case "9": addSupportLog(); break;
                case "10": backupService.backupData(); break;
                case "11": backupService.printRecoverySteps(); break;
                case "12": printSystemReport(); break;
                case "0": running = false; break;
                default: System.out.println("Invalid option. Please try again.");
            }
        }
        System.out.println("Thank you for using Feast-Hub.");
    }

    private static void printMenu() {
        System.out.println("\n========= Feast-Hub Menu =========");
        System.out.println("1. View recipes");
        System.out.println("2. Search recipe");
        System.out.println("3. Add recipe");
        System.out.println("4. Rate recipe");
        System.out.println("5. View pantry");
        System.out.println("6. Add pantry item");
        System.out.println("7. Suggest recipes from pantry");
        System.out.println("8. View support log");
        System.out.println("9. Add support log");
        System.out.println("10. Backup data");
        System.out.println("11. Recovery steps");
        System.out.println("12. System report");
        System.out.println("0. Exit");
    }

    private static void searchRecipe() {
        System.out.print("Enter keyword: ");
        recipeService.searchRecipe(scanner.nextLine());
    }

    private static void addRecipe() {
        System.out.print("Recipe title: ");
        String title = scanner.nextLine();
        System.out.print("Ingredients separated by | : ");
        String ingredients = scanner.nextLine();
        System.out.print("Instructions: ");
        String instructions = scanner.nextLine();

        if (InputValidator.isNotBlank(title) && InputValidator.isNotBlank(ingredients)) {
            recipeService.addRecipe(title, ingredients, instructions);
        } else {
            System.out.println("Title and ingredients cannot be blank.");
        }
    }

    private static void rateRecipe() {
        try {
            System.out.print("Recipe ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Rating 1-5: ");
            double rating = Double.parseDouble(scanner.nextLine());
            if (InputValidator.isValidRating(rating)) {
                recipeService.rateRecipe(id, rating);
            } else {
                System.out.println("Rating must be between 1 and 5.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers.");
        }
    }

    private static void addPantryItem() {
        try {
            System.out.print("Ingredient name: ");
            String name = scanner.nextLine();
            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Expiry date YYYY-MM-DD: ");
            String expiry = scanner.nextLine();
            pantryService.addPantryItem(name, quantity, expiry);
        } catch (NumberFormatException e) {
            System.out.println("Quantity must be a number.");
        }
    }

    private static void addSupportLog() {
        System.out.print("Problem: ");
        String problem = scanner.nextLine();
        System.out.print("Solution: ");
        String solution = scanner.nextLine();
        System.out.print("Status: ");
        String status = scanner.nextLine();
        supportLogService.addLog(problem, solution, status);
    }

    private static void printSystemReport() {
        System.out.println("\nSystem Performance Report");
        System.out.println("Recipes stored: " + recipeService.getAllRecipes().size());
        System.out.println("Pantry items stored: " + pantryService.getPantryItems().size());
        System.out.println("Application status: Running");
        System.out.println("Storage type: Local CSV files");
        System.out.println("Support workflow: Problems and solutions log enabled");
    }
}
