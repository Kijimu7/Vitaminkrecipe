package com.example.vitaminkrecipe.network;


        import com.example.vitaminkrecipe.model.Result;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Query;

public interface GetDataService{

    @GET("search")
    Call<Result> getSearch(@Query("q") String query, @Query("count") Integer count, @Query("totalNutrients") String totalNutrients, @Query("app_id") String app_id, @Query("app_key") String app_key);

}