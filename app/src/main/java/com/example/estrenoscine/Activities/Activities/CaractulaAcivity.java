package com.example.estrenoscine.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.estrenoscine.R;

public class CaractulaAcivity extends AppCompatActivity {
    ImageView cover;
    TextView sinopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caractula);

        cover = findViewById(R.id.coverCaractullaAcivity);
        cover.setImageResource(getIntent().getIntExtra("idCover",-1));
        cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watchYoutubeVideo(getIntent().getStringExtra("idMovie"));
            }
        });

        sinopsis = findViewById(R.id.sinopsisCaractulaActivity);
        sinopsis.setText(getIntent().getStringExtra("sinopsis"));
    }

    public  void watchYoutubeVideo(String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }

}
