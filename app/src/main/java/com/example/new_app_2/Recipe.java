package com.example.new_app_2;

import java.util.List;

public class Recipe {
    private String name;
    private String ingredients;
    private String instructions;
    private List<String> foodItems;

    public Recipe(String name, String ingredients, String instructions, List<String> foodItems) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.foodItems = foodItems;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public List<String> getFoodItems() {
        return foodItems;
    }
}
