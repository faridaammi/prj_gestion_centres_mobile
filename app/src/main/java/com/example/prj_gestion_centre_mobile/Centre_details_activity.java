package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import Controller.Centre_detailsController;

public class Centre_details_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre_details);
        int[] imglist = {R.drawable.img_centre,R.drawable.img_centre2,R.drawable.img_centre3};
       Centre_detailsController controller = new Centre_detailsController(this,imglist);
        RecyclerView recyclerView= findViewById(R.id.recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(controller);
    }
}