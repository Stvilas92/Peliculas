package com.example.estrenoscine.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.estrenoscine.Activities.Adapters.ListadoCompletoAdapter;
import com.example.estrenoscine.Activities.Objects.Pelicula;
import com.example.estrenoscine.R;

import java.util.ArrayList;

public class ListadoCompletoActivity extends AppCompatActivity {
    RecyclerView rv;
    ListadoCompletoAdapter adapter;
    ArrayList<Pelicula>movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ArrayList<Pelicula> movies =(ArrayList<Pelicula>) getIntent().getExtras().getSerializable("movies");
        setContentView(R.layout.activity_listado_completo);
        rv = findViewById(R.id.rvPeliculaCompleta);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(lm);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula p = movies.get(rv.getChildAdapterPosition(v));
                startActivity(p);
            }
        };

        adapter = new ListadoCompletoAdapter(movies,rv);
        adapter.setListener(listener);
        rv.setAdapter(adapter);
    }


    public void startActivity(Pelicula p){
        Intent intent = new Intent(getApplicationContext(), CaractulaAcivity.class);
        intent.putExtra("idCover",p.portada);
        intent.putExtra("sinopsis",p.sinopsis );
        intent.putExtra("idMovie",p.idYoutube);
         startActivity(intent);
    }
}
