package com.example.prj_gestion_centre_mobile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import Controller.Centre_detailsController;
import Controller.Centre_favorisController;
import Model.Centre;
import Model.Publication;


public class FavorisFragment extends Fragment {


    private RecyclerView recyclerViewFav;
    private List<Centre> listItems;
    GridLayoutManager gridLayoutManager;
    private RecyclerView.Adapter adapterFavoris;
    public FavorisFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

          return inflater.inflate(R.layout.fragment_favoris, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewFav=view.findViewById(R.id.recyclerViewFav);
        gridLayoutManager=new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerViewFav.setLayoutManager(gridLayoutManager);
        //recyclerViewFav.setHasFixedSize(true);
        listItems=new ArrayList<>();
        //int id_centre, String nom_centre, String adresse_centre, String descriptioncentre,boolean favoris_centre,int img_centre)
        Centre c1=new Centre("CEFT IBN ZOHR-TIZNIT",R.drawable.img_centre);
        Centre c2=new Centre("CEFT IBN ZOHR-TIZNIT",R.drawable.img_centre2);
        Centre c3=new Centre("CEFT IBN ZOHR-TIZNIT",R.drawable.img_centre3);
        Centre c4=new Centre("CEFT IBN ZOHR-TIZNIT",R.drawable.img_centre);

        listItems.add(c1);
        listItems.add(c2);
        listItems.add(c3);
        listItems.add(c4);
        adapterFavoris=new Centre_favorisController(getContext(),listItems);
        recyclerViewFav.setAdapter(adapterFavoris);
        adapterFavoris.notifyDataSetChanged();
    }
}