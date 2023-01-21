package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import Controller.Centre_detailsController;
import Controller.Salle_Controller;
import Model.Salle;

public class Centre_details_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre_details);
        ArrayList<Salle> listsalle= new ArrayList<Salle>(
                Arrays.asList(new Salle(149,"14"),new Salle(30,"4"),
                       new Salle(230,"12"),new Salle(50,"6") ));
        int[] imglist = {R.drawable.img_centre,R.drawable.img_centre2,R.drawable.img_centre3};
       Centre_detailsController controller = new Centre_detailsController(this,imglist);
        Salle_Controller salleController = new Salle_Controller(this,listsalle);
        RecyclerView recyclerView= findViewById(R.id.recycleview);
        RecyclerView recyclerView1 =findViewById(R.id.recycleviewSALLE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(controller);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setAdapter(salleController);



    }
}