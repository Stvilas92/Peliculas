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

public class ListadoCompletoAdapter extends RecyclerView.Adapter<ListadoCompletoAdapter.ViewHolder> implements View.OnClickListener {
    View.OnClickListener listener;
    ArrayList<Pelicula> movies;
    RecyclerView rv;

    public ListadoCompletoAdapter(ArrayList<Pelicula> movies, RecyclerView rv){
            this.movies = movies;
            this.rv = rv;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_activity_adapter,parent,false);
        view.setOnClickListener(this);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pelicula p = movies.get(position);
        holder.age.setImageResource(p.clasi);
        holder.cover.setImageResource(p.portada);
        holder.director.setText(p.director);
        holder.movie.setText(p.titulo);
        holder.room.setText(p.sala);
        holder.dateLaunch.setText(p.fecha.getDay() +"/"+p.fecha.getMonth()+"/"+p.fecha.getYear());
        holder.duration.setText(""+p.duracion);


        if(p.getFavorita()) {
            holder.favorite.setImageResource(R.mipmap.favorite);

        }
        else  holder.favorite.setImageResource(android.R.drawable.screen_background_dark_transparent);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
    public TextView duration,room,movie,director,dateLaunch;
    public ImageView cover,age,favorite;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        duration = itemView.findViewById(R.id.duration);
        room = itemView.findViewById(R.id.room);
        movie = itemView.findViewById(R.id.movieComplete);
        director = itemView.findViewById(R.id.directorComplete);
        cover = itemView.findViewById(R.id.coverComplete);
        favorite = itemView.findViewById(R.id.favorite);
        age = itemView.findViewById(R.id.ageComplete);
        dateLaunch = itemView.findViewById(R.id.dateLaunch);
    }
}
}


