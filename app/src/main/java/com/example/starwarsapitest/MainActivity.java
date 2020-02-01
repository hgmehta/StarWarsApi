package com.example.starwarsapitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.sax.StartElementListener;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Result> result;

    StarWarsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataService service = RetrofitClient.getRetrofitInstance().create(DataService.class);

        Call<StarWars> call = service.getStarWarsResult();

        call.enqueue(new Callback<StarWars>() {
            @Override
            public void onResponse(Call<StarWars> call, Response<StarWars> response) {
                StarWars starWars = response.body();
                try {
                    result = new ArrayList<>(starWars.getResults());
                    generateRecyclerView(result);
                }catch (NullPointerException exception){

                }

            }

            @Override
            public void onFailure(Call<StarWars> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something Went Wrong!" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void generateRecyclerView(ArrayList<Result> result){

        adapter = new StarWarsAdapter(result, getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView_starwars);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
