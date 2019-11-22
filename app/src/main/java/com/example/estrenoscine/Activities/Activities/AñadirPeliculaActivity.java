package com.example.estrenoscine.Activities.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.estrenoscine.Activities.Objects.DateDialog;
import com.example.estrenoscine.R;

public class AñadirPeliculaActivity extends AppCompatActivity {
    private static final int ADD_ACIVITY = 101;

    private Spinner sp;
    private EditText etTitle,etDuration,etDirector;
    private RadioGroup ageGroup;
    private String room,date;
    private int age;
    private DateDialog dateDialog;
    private Button selectDate;
    public TextView dateSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_pelicula);


        //Intance spinner
        sp = findViewById(R.id.spinnerCinemaRooms);
        ArrayAdapter<String> spAdapter = new ArrayAdapter<String> (this,R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.ages));
        sp.setAdapter(spAdapter);

        //Edit texts instance
        etTitle = findViewById(R.id.etAddMovie);
        etDirector = findViewById(R.id.etAddDirector);
        etDuration = findViewById(R.id.etAddDuration);

        //Radio group
        ageGroup = findViewById(R.id.grAddBtn);

        //Date dialog
        dateDialog= new DateDialog();

        //Select date button and listener
        selectDate = findViewById(R.id.selectDate);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateDialog.show(getSupportFragmentManager (),"date");
            }
        });

        //Textview date selected
        dateSelected = findViewById(R.id.dateSelected);

        ageGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String ageString = ((RadioButton)findViewById(checkedId)).getText().toString();
                if(ageString.equals("Todos los publicos")){
                    age = R.drawable.g ;
                }else if(ageString.equals("Mayores de 10 años")){
                    age = R.drawable.pg ;
                }else if(ageString.equals("Mayores de 13 años")){
                    age = R.drawable.pg13 ;
                }else if(ageString.equals("Mayores de 17 años")){
                    age = R.drawable.r ;
                }else {
                    age = R.drawable.nc17 ;
                }
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                room = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setDate(String date){
        this.date = date;
    }


    public void setResult(){
        Intent intent = new Intent();
        intent.putExtra("title",etTitle.getText().toString());
        intent.putExtra("director",etDirector.getText().toString());
        intent.putExtra("duration",Integer.parseInt(etDuration.getText().toString()));
        intent.putExtra("age",age);
        intent.putExtra("date",date);
        intent.putExtra("room",room);
        this.setResult(RESULT_OK,intent);
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
