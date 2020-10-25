package com.example.vitaminkrecipetest;

import com.example.vitaminkrecipetest.model.RecipePhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RecipeClientInstance {

    private static Retrofit retrofit;
    public static final String BASE_URL = "https://api.edamam.com/search/?q=chicken&&from=0&to=3&calories=591-722&health=alcohol-free/";

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        }
        return retrofit;
    }



}
