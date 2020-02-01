package com.example.starwarsapitest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StarWarsAdapter extends RecyclerView.Adapter<StarWarsAdapter.ViewHolder> {

    View.OnClickListener listener;
    ArrayList<Result> results;
    TextView textView_name;
    private Context context;

    public StarWarsAdapter(ArrayList<Result> results, Context context){
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        textView_name.setText(results.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            textView_name=itemView.findViewById(R.id.name);
        }
    }
}
