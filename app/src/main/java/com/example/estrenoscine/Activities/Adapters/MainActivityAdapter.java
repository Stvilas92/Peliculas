package com.example.estrenoscine.Activities.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estrenoscine.Activities.Objects.Pelicula;
import com.example.estrenoscine.R;

import java.util.ArrayList;

public class MainActivityAdapter extends  RecyclerView.Adapter<MainActivityAdapter.MyViewHolder> implements View.OnClickListener {
    ArrayList<Pelicula> movies;
    RecyclerView rv;
    int selectedPos=RecyclerView.NO_POSITION;

    View.OnClickListener listener;

    public MainActivityAdapter(ArrayList<Pelicula> movies, RecyclerView rv) {
        this.movies = movies;
        this.rv = rv;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_activity_adapter,parent,false);
        view.setOnClickListener(this);
        MyViewHolder my = new MyViewHolder(view);
        return my;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pelicula p = movies.get(position);
        holder.ivCover.setImageResource(p.portada);
        holder.ivAge.setImageResource(p.clasi);
        holder.tvTitle.setText(p.titulo);
        holder.tvDirector.setText(p.director);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCover,ivAge;
        TextView tvTitle,tvDirector;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             ivCover= itemView.findViewById(R.id.cover);
             ivAge= itemView.findViewById(R.id.age);
             tvTitle= itemView.findViewById(R.id.movie);
             tvDirector= itemView.findViewById(R.id.addDirector);
        }
    }
}