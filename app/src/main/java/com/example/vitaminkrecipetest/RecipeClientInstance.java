package com.example.vitaminkrecipetest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeClientInstance {

    private static Retrofit retrofit;
    public static final String BASE_URL = "https://api.edamam.com";

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
