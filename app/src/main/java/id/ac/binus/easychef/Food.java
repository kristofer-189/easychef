package id.ac.binus.easychef;

import java.io.Serializable;
import java.util.ArrayList;


public class Food implements Serializable {
    private String name, type, description, difficulty;
    private ArrayList<String> ingredients;
    private int likes, image;
    private Recipe recipes;

    public Food(String name, String type, String description, String difficulty,  ArrayList<String> ingredients, int likes, Recipe recipes, int image) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.ingredients = ingredients;
        this.difficulty = difficulty;
        this.likes = likes;
        this.recipes = recipes;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Recipe getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipe recipes) {
        this.recipes = recipes;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
