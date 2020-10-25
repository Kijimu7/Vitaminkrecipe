package com.example.vitaminkrecipetest;

import com.google.gson.Gson;

public class Hits {
    Gson gson = new Gson();
    String jsonArray = "....";
    Hits hits = gson.fromJson(jsonArray, Hits.class);
}
