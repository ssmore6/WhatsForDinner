package com.example.sugnani.whatsfordinner;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<String> ingredients;
    private String description;

    public Recipe(){

    }
    public Recipe(String name, ArrayList<String> ingredients,String description){
        name = this.name;
        ingredients = this.ingredients;
        description = this.description;
    }

    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }

    public ArrayList<String> getIngredients(){
        return ingredients;
    }

    public void addIngredient(int n, String i){
        if(i != null){
            ingredients.add(n,i);
        }

    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String d){
        description = d;
    }
}
