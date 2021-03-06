package com.example.vitaminkrecipe.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.vitaminkrecipe.Adapter.CustomAdapter;
import com.example.vitaminkrecipe.R;
import com.example.vitaminkrecipe.RecipeClientInstance;
import com.example.vitaminkrecipe.model.Hit;
import com.example.vitaminkrecipe.model.Result;
import com.example.vitaminkrecipe.network.GetDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    ProgressDialog progressDialog;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    private static final String TAG = "MyActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
      Log.d("test", "test");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();



        RecyclerView recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(new ArrayList<Hit>(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);




        //Create handle for the RetrofitInstance interface

        GetDataService service = RecipeClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Result> call = service.getSearch("chicken", 5, "VITK1","107422fa", "a3784e41fd63db8052d0d7cba9e6384c");
        call.enqueue(new Callback<Result>(){
            @Override
            public void onResponse(Call<Result> call, Response<Result> response){
                progressDialog.dismiss();



                adapter.addAll(response.body().getHits());
//                adapter.notifyDataSetChanged();


                Log.d("response", response.toString());


            }


            @Override
            public void onFailure(Call<Result> call, Throwable t){
                progressDialog.dismiss();

                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                Log.d (TAG, "message", t);
            }

        });
    }



}


//Method to generate List of data using RecyclerView with custom adapter
//    private void generateDataList(List<Hits> photoList){
//        RecyclerView recyclerView = findViewById(R.id.customRecyclerView);
//        CustomAdapter adapter = new CustomAdapter(this, photoList);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
