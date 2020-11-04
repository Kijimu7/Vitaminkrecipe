package com.example.vitaminkrecipetest.model;

import com.example.vitaminkrecipetest.model.VITK1;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalNutrients {

    @SerializedName("VITK1")
    @Expose
    private VITK1 vITK1;

    public VITK1 getvITK1() {
        return vITK1;
    }

    public void setvITK1(VITK1 vITK1) {
        this.vITK1 = vITK1;
    }
}
