package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Controller.AccueilController;
import Model.Publication;

public class AccueilActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPub;
    private List<Publication> listItems;
    LinearLayoutManager layoutManager;
    private RecyclerView.Adapter adapterPublication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        recyclerViewPub = findViewById(R.id.recyclerViewPub);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewPub.setLayoutManager(layoutManager);
        recyclerViewPub.setHasFixedSize(true);
        //recyclerViewPub.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        Publication items1 =new Publication(R.drawable.icon_profile,"CEFT IBN ZOHR - TIZNIT","12/01/2023","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here,",R.drawable.img_publication);
        Publication items2 =new Publication(R.drawable.icon_profile2,"Centre Med khair eddin","22/12/2022","بدأ العد التنازلي للمهرجان الدولي للمسرح والثقافات... نتلاقاو فالمسرح.",R.drawable.img_pub2);

        listItems.add(items1);
        listItems.add(items2);

        adapterPublication=new AccueilController(this,listItems);
        recyclerViewPub.setAdapter(adapterPublication);
        adapterPublication.notifyDataSetChanged();

    }
}