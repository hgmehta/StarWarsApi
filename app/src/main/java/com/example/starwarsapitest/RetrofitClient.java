package com.example.starwarsapitest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String Base_url = "https://swapi.co/api/";

    public static Retrofit getRetrofitInstance(){


        if (retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(Base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }
}
