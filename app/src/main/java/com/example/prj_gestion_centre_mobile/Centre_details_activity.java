package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import Controller.Centre_detailsController;
import Controller.Commentaire_Controller;
import Controller.Salle_Controller;
import Model.Commentaire;
import Model.Salle;
import Model.Utilisateur;

public class Centre_details_activity extends AppCompatActivity {
public static ArrayList<Utilisateur> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String cmnt= "Centre très agréable et confortable, merci d'avoir accompagné mon exposant";
        setContentView(R.layout.activity_centre_details);
        list= new ArrayList<>(Arrays.asList(new Utilisateur(1,"Hakim ELHAIBA",R.drawable.icon_profile),
                new Utilisateur(2,"Doon Kaiji",R.drawable.icon_profile2),new Utilisateur(3,"GUITAR TIZ ASSO",R.drawable.icon_profile)));

        ArrayList<Commentaire> listcmnts = new ArrayList<>(Arrays.asList(new Commentaire(1,"Nov 25,2022",cmnt,1),
                new Commentaire(2,"Oct 10,2021",cmnt,2),new Commentaire(1,"Dec 11,2022",cmnt,3)));
        ArrayList<Salle> listsalle= new ArrayList<Salle>(
                Arrays.asList(new Salle(149,"14"),new Salle(30,"4"),
                       new Salle(230,"12"),new Salle(50,"6") ));
        int[] imglist = {R.drawable.img_centre,R.drawable.img_centre2,R.drawable.img_centre3};
        Centre_detailsController controller = new Centre_detailsController(this,imglist);
        Salle_Controller salleController = new Salle_Controller(this,listsalle);
        Commentaire_Controller cmntcontroller = new Commentaire_Controller(this,listcmnts);
        RecyclerView recyclerView= findViewById(R.id.recycleview);
        RecyclerView recyclerViewcmnt= findViewById(R.id.recycleviewcmnts);
        RecyclerView recyclerView1 =findViewById(R.id.recycleviewSALLE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(controller);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setAdapter(salleController);
        recyclerViewcmnt.setLayoutManager(layoutManager2);
        recyclerViewcmnt.setAdapter(cmntcontroller);



    }
}