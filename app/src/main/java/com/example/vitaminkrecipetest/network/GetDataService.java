package com.example.vitaminkrecipetest.network;


import com.example.vitaminkrecipetest.model.RecipePhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService{

    @GET("/hits")
    Call<List<RecipePhoto>> getAllhits();

}