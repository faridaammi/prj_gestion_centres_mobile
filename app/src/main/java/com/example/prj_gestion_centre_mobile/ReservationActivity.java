package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationActivity extends AppCompatActivity {
    CalendarView calendarView;
    TextView datedepart, datefin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        calendarView= (CalendarView) findViewById(R.id.calendarView);
        datedepart= (TextView) findViewById(R.id.txt_datedepart);
        datefin = (TextView) findViewById(R.id.txt_datefin);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                SimpleDateFormat monthParse = new SimpleDateFormat("MM");
                SimpleDateFormat monthDisplay = new SimpleDateFormat("MMM");

                try {
                    datedepart.setText( monthDisplay.format(monthParse.parse(String.valueOf(month+1)))+" "+String.valueOf(dayOfMonth));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}