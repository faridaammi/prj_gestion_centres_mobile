package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import Controller.Centre_detailsController;
import Controller.Commentaire_Controller;
import Controller.Salle_Controller;
import Model.Centre;
import Model.Commentaire;
import Model.Salle;
import Model.Utilisateur;

public class Centre_details_activity extends AppCompatActivity {
public static ArrayList<Utilisateur> list;
Centre centre;
TextView txt_nomcentre,txt_adresse,txt_descreption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre_details);
        Intent intent = getIntent();
        txt_nomcentre= (TextView) findViewById(R.id.txtnom_centre);
        txt_adresse= (TextView) findViewById(R.id.txt_adresse);
        txt_descreption= (TextView) findViewById(R.id.txt_description);
        centre =(Centre) intent.getSerializableExtra("centre");
        txt_adresse.setText(centre.getAdresse_centre());
        txt_descreption.setText(centre.getDescriptioncentre());
        txt_nomcentre.setText(centre.getNom_centre());
        String cmnt= "Centre très agréable et confortable, merci d'avoir accompagné mon exposant";
        list= new ArrayList<>(Arrays.asList(new Utilisateur(1,"Hakim ELHAIBA",R.drawable.icon_profile),
                new Utilisateur(2,"Doon Kaiji",R.drawable.icon_profile2),new Utilisateur(3,"GUITAR TIZ ASSO",R.drawable.icon_profile)));
       //  centre =new Centre("CEFT IBN ZOHR-TIZNIT",R.drawable.img_centre);
        ArrayList<Commentaire> listcmnts = new ArrayList<>(Arrays.asList(new Commentaire(1,"Nov 25,2022",cmnt,1),
                new Commentaire(2,"Oct 10,2021",cmnt,2),new Commentaire(1,"Dec 11,2022",cmnt,3),new Commentaire(2,"Oct 10,2021",cmnt,2)));
        ArrayList<Salle> listsalle= new ArrayList<Salle>(
                Arrays.asList(new Salle(149,"14"),new Salle(30,"4"),
                       new Salle(230,"12"),new Salle(50,"6"),
                        new Salle(28,"45")));
//        listsalle.get(3).setImage_salle(R.drawable.img_salle2);
//        listsalle.get(0).setImage_salle(R.drawable.img_salle);
        int[] imglist = {R.drawable.img_centre,R.drawable.img_centre2,R.drawable.img_centre3};
        Centre_detailsController controller = new Centre_detailsController(this,centre.getImgs_centre());
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
        centre.setSalles_centre(listsalle);

    }

    public void reserver(View view) {
        Intent intent = new Intent(this,ReservationActivity.class);
        intent.putExtra("Centre",centre);
        startActivity(intent);
    }
}