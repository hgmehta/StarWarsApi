package com.example.starwarsapitest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("people?format=json")
    Call<StarWars> getStarWarsResult();
}
