package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import Controller.Salle_Controller;
import Model.Centre;
import Model.Salle;

import Controller.Salle_Controller;
import Model.Centre;
import Model.Salle;

public class ReservationActivity extends AppCompatActivity{
    CalendarView calendarView;
    RecyclerView recyclerView;
    TextView datedepart, datefin, txtinvite;
    Button btn_addinvite,btn_deleteinvite ;
    int comptinvite=0;
    RadioGroup radio_group_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent centreintent = getIntent();
        Centre centre =(Centre) centreintent.getSerializableExtra("Centre");
        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        setContentView(R.layout.activity_reservation);
        btn_addinvite = (Button) findViewById(R.id.btnaddinvite);
        btn_deleteinvite=(Button)findViewById(R.id.btndeleteinvite);
        calendarView= (CalendarView) findViewById(R.id.calendarView);
        datedepart= (TextView) findViewById(R.id.txt_datedepart);
        datefin = (TextView) findViewById(R.id.txt_datefin);
        txtinvite = (TextView) findViewById(R.id.txt_invite);
        radio_group_date= (RadioGroup) findViewById(R.id.radio_group_date);
        recyclerView = (RecyclerView) findViewById(R.id.rceyclesalle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        Salle_Controller salleController = new Salle_Controller(this,centre.getSalles_centre());
        recyclerView.setAdapter(salleController);
        datedepart.setText(new SimpleDateFormat("MMM").format(new Date())+new SimpleDateFormat("D").format(new Date()));
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                SimpleDateFormat monthParse = new SimpleDateFormat("MM");
                SimpleDateFormat monthDisplay = new SimpleDateFormat("MMM");

                try {
                    if(radio_group_date.getCheckedRadioButtonId()==R.id.rb_date_debut){
                        datedepart.setText( monthDisplay.format(monthParse.parse(String.valueOf(month+1)))+" "+String.valueOf(dayOfMonth));
                    }else{
                        datefin.setText( monthDisplay.format(monthParse.parse(String.valueOf(month+1)))+" "+String.valueOf(dayOfMonth));
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

    }



    public void deleteinvite(View view) {
        comptinvite--;
        comptinvite = comptinvite<0?0:comptinvite;
        txtinvite.setText(String.valueOf(comptinvite));
    }

    public void addinvite(View view) {
        comptinvite++;
        txtinvite.setText(String.valueOf(comptinvite));

    }

    public void continuereservation(View view) {
        Intent intent = new Intent(this,ReservationdetailsActivity.class);
        startActivity(intent);
    }
}