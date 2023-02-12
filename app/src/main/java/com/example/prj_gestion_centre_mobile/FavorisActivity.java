package com.example.prj_gestion_centre_mobile;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controller.Centre_favorisController;
import Model.Centre;
import Model.Salle;

public class FavorisActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFav;
    private List<Centre> listItems;
    GridLayoutManager gridLayoutManager;
    private RecyclerView.Adapter adapterFavoris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);
        recyclerViewFav=findViewById(R.id.recyclerViewFav);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Enregistrements");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        gridLayoutManager=new GridLayoutManager(this,2,RecyclerView.VERTICAL,false);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewFav.setLayoutManager(gridLayoutManager);
        //recyclerViewFav.setHasFixedSize(true);
        listItems=new ArrayList<>();
        ArrayList<Salle> listsalle= new ArrayList<Salle>(
                Arrays.asList(new Salle(149,"14"),new Salle(30,"4"),
                        new Salle(230,"12"),new Salle(50,"6"),
                        new Salle(28,"45")));
        ArrayList<Salle> listsalle1= new ArrayList<Salle>(
                Arrays.asList(new Salle(149,"14"),new Salle(30,"4"),
                        new Salle(230,"12"),
                        new Salle(28,"45")));
        ArrayList<Salle> listsalle2= new ArrayList<Salle>(
                Arrays.asList(
                        new Salle(230,"12"),new Salle(50,"6"),
                        new Salle(28,"45")));
        //int id_centre, String nom_centre, String adresse_centre, String descriptioncentre,boolean favoris_centre,int img_centre)
      /*
        Centre c1=new Centre("CEFT IBN ZOHR-TIZNIT",R.drawable.img_centre);
        Centre c2=new Centre("CEFT IBN ZOHR-TIZNIT",R.drawable.img_centre2);
        Centre c3=new Centre("CEFT IBN ZOHR-TIZNIT",R.drawable.img_centre3);
        Centre c4=new Centre("CEFT IBN ZOHR-TIZNIT",R.drawable.img_centre);
        c1.setSalles_centre(listsalle);
        c2.setSalles_centre(listsalle1);
        c3.setSalles_centre(listsalle2);


        listItems.add(c1);
        listItems.add(c2);
        listItems.add(c3);
        listItems.add(c4);

       */
        adapterFavoris=new Centre_favorisController(this,listItems);
        recyclerViewFav.setAdapter(adapterFavoris);
        adapterFavoris.notifyDataSetChanged();
    }
}