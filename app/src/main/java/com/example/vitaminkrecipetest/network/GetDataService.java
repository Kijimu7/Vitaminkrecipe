package com.example.vitaminkrecipetest.network;


import com.example.vitaminkrecipetest.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService{

    @GET("/search")
    Call<Result> getAllPhotos(@Query("q") String query, @Query("app_id") String app_id, @Query("app_key") String app_key);

}