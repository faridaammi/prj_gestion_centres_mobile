package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Controller.NotificationController;
import Model.Centre;
import Model.Reservation;

public class NotificationActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotif;
    private List<Reservation> listItems;
    LinearLayoutManager layoutManager;
    private RecyclerView.Adapter adapterNotif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        recyclerViewNotif = findViewById(R.id.recyclerViewNotif);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Notifications");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewNotif.setLayoutManager(layoutManager);
        recyclerViewNotif.setHasFixedSize(true);
        listItems = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date d1,d2,d3,d4;
        try {
            d1 = df.parse("12-01-2023");
            d2 = df.parse("24-12-2022");
            d3 = df.parse("08-10-2022");
            d4 = df.parse("16-02-2023");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Reservation item1 = new Reservation(d1, "En cours", "Conference");
        Reservation item2 = new Reservation(d2, "Acceptee", "Evenements");
        Reservation item3 = new Reservation(d3, "Refusee", "Theatre");
        Reservation item4 = new Reservation(d4, "Acceptee", "Formation");
        listItems.add(item1);
        listItems.add(item2);
        listItems.add(item3);
        listItems.add(item4);
        adapterNotif = new NotificationController(this, listItems);
        recyclerViewNotif.setAdapter(adapterNotif);
        adapterNotif.notifyDataSetChanged();
    }
}