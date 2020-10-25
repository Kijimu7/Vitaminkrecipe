package com.example.vitaminkrecipetest.model;

import com.google.gson.annotations.SerializedName;

public class Recipe {
    @SerializedName("uri")
    public String uri;
    @SerializedName("label")
    public String label;
    @SerializedName("image")
    public String image;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
