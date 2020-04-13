package com.tuli.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Calendar calendar;
    private int year,month,day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);

    }
DatePickerDialog.OnDateSetListener dateListener =new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        calendar.set(year,month,dayOfMonth);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String userDate= sdf.format(calendar.getTime());

        ((Button)findViewById(R.id.dateBtn)).setText(userDate);


    }
};
    public void selectdate(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,dateListener,year,month,day
        );
        datePickerDialog.show();
    }

    public void selecttime(View view) {
    }
}
