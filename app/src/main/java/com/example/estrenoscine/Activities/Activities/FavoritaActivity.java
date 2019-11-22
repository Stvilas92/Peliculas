package com.example.estrenoscine.Activities.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.estrenoscine.R;

import java.util.ArrayList;

public class FavoritaActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList<String> moviesTitle;
    ArrayList<String> moviesSelected;
    ArrayList<String> moviesFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorita);

        moviesTitle = getIntent().getExtras().getStringArrayList("movies");
        moviesFavorites = getIntent().getExtras().getStringArrayList("favorites");
        moviesSelected = moviesFavorites;

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_checked,moviesTitle);
        lv = findViewById(R.id.listMovies);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        if(moviesFavorites.size() > 0){
            setFavorites(moviesFavorites);
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                boolean flag = true;

                for(String s : moviesSelected){
                    if(s.equals(moviesTitle.get(position))){
                        removeMovieSelected(moviesTitle.get(position));
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    moviesSelected.add(moviesTitle.get(position));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult();
    }

    public void removeMovieSelected(String movieToDelete){
        for(int i = 0; i < moviesSelected.size();i++){
            if(moviesSelected.get(i).equals(movieToDelete)){
                moviesSelected.remove(i);
                return;
            }
        }
    }

    public void setFavorites(ArrayList<String> moiesFavorites){
        for(int i = 0; i < moviesTitle.size();i++){
            boolean flag = false;
            for(int j = 0 ; j < moviesFavorites.size(); j++){
                if(moviesTitle.get(i).equals(moviesFavorites.get(j))){
                     lv.setItemChecked(i,true);
                }
            }
        }
    }

    public void setResult(){
        Intent intent = new Intent();
        intent.putExtra("favorites",moviesSelected);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.save_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.save){
            setResult();
            return true;
        }
        return false;
    }
}
