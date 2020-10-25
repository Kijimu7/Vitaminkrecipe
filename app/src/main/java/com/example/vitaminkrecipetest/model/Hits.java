package com.example.vitaminkrecipetest.model;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

public class Hits {
    @SerializedName("recipe")
    public Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }


    public Uri getImage() {
        return null;
    }

    public Hits getLable() {
        return null;
    }
}
