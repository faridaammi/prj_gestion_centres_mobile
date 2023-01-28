package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
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

public class ReservationActivity extends AppCompatActivity {
    CalendarView calendarView;
    RecyclerView recyclerView;
    TextView datedepart, datefin, txtinvite;
    Button btn_addinvite,btn_deleteinvite ;
    int comptinvite=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Salle> listsalle= new ArrayList<Salle>(
                Arrays.asList(new Salle(149,"14"),new Salle(30,"4"),
                        new Salle(230,"12"),new Salle(50,"6"),
                        new Salle(28,"45")));
        listsalle.get(3).setImage_salle(R.drawable.img_salle2);
        listsalle.get(0).setImage_salle(R.drawable.img_salle);
        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        setContentView(R.layout.activity_reservation);
        btn_addinvite = (Button) findViewById(R.id.btnaddinvite);
        btn_deleteinvite=(Button)findViewById(R.id.btndeleteinvite);
        calendarView= (CalendarView) findViewById(R.id.calendarView);
        datedepart= (TextView) findViewById(R.id.txt_datedepart);
        datefin = (TextView) findViewById(R.id.txt_datefin);
        txtinvite = (TextView) findViewById(R.id.txt_invite);
        recyclerView = (RecyclerView) findViewById(R.id.rceyclesalle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        Salle_Controller salleController = new Salle_Controller(this,listsalle);
        recyclerView.setAdapter(salleController);
        datedepart.setText(new SimpleDateFormat("MMM").format(new Date())+new SimpleDateFormat("D").format(new Date()));
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



    public void deleteinvite(View view) {
        comptinvite--;
        comptinvite = comptinvite<0?0:comptinvite;
        txtinvite.setText(String.valueOf(comptinvite));
    }

    public void addinvite(View view) {
        comptinvite++;
        txtinvite.setText(String.valueOf(comptinvite));

    }
}