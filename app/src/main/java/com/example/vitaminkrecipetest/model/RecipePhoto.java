package com.example.vitaminkrecipetest.model;

import com.example.vitaminkrecipetest.Hits;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;

public class RecipePhoto {

    @SerializedName("q")
    private String q;
    @SerializedName("from")
    private Integer from;
    @SerializedName("to")
    private Integer to;
    @SerializedName("hits")
    List<Hits> hits;
    @SerializedName("image")
    private String image;
    @SerializedName("label")
    private String label;



    public RecipePhoto(String q, Integer from, Integer to, String image, String label){
        this.q = q;
        this.from = from;
        this.to = to;
        this.image = image;
        this.label = label;

}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Hits> getHits() {
        return hits;
    }

    public void setHits(List<Hits> hits) {
        this.hits = hits;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }


}