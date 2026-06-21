package com.feasthub.model;

public class Ingredient {
    private String name;
    private int quantity;
    private String expiryDate;

    public Ingredient(String name, int quantity, String expiryDate) {
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public String getExpiryDate() { return expiryDate; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return name + " | Quantity: " + quantity + " | Expiry: " + expiryDate;
    }
}
