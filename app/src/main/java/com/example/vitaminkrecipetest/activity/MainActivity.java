package com.example.vitaminkrecipetest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.vitaminkrecipetest.Adapter.CustomAdapter;
import com.example.vitaminkrecipetest.R;
import com.example.vitaminkrecipetest.RecipeClientInstance;
import com.example.vitaminkrecipetest.model.RecipePhoto;
import com.example.vitaminkrecipetest.network.GetDataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        //Create handle for the RetrofitInstance interface

        GetDataService service = RecipeClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RecipePhoto>> call = service.getAllhits();
        call.enqueue(new Callback<List<RecipePhoto>>(){
            @Override
            public void onResponse(Call<List<RecipePhoto>> call, Response<List<RecipePhoto>> response){
                progressDialog.dismiss();
                generateDataList(response.body());
            }


            @Override
            public void onFailure( Call<List<RecipePhoto>> call, Throwable t){
                progressDialog.dismiss();

                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }

        });
    }

    //Method to generate List of data using RecyclerView with custom adapter
    private void generateDataList(List<RecipePhoto> photoList){
        RecyclerView recyclerView = findViewById(R.id.customRecyclerView);
        CustomAdapter adapter = new CustomAdapter(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        }


}