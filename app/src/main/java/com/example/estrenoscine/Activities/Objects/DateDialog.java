package com.example.estrenoscine.Activities.Objects;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import com.example.estrenoscine.Activities.Activities.AñadirPeliculaActivity;

import java.util.Calendar;

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar. MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        ((AñadirPeliculaActivity)getActivity()).setDate(year+"-"+month+"-"+dayOfMonth);
        ((AñadirPeliculaActivity)getActivity()).dateSelected.setText(""+year+"-"+month+"-"+dayOfMonth);
    }
}
