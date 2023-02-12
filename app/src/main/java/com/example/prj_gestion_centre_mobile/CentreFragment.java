package com.example.prj_gestion_centre_mobile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import Controller.CategorieController;
import Controller.CentreController;
import Model.Centre;


public class CentreFragment extends Fragment {
    RecyclerView recyclerView;
    TextView nom_organisme;
    ArrayList<String> list_categorie;
  public static   CentreController adapter1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CentreFragment() {
        // Required empty public constructor
    }


    public static CentreFragment newInstance(String param1, String param2) {
        CentreFragment fragment = new CentreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_centre, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclercategorie);
        nom_organisme=view.findViewById(R.id.txt_nomorganisme);
        nom_organisme.setText(SignIn.nom_organisme.equals("null")?"Asma":SignIn.nom_organisme);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        list_categorie = new ArrayList<>(Arrays.asList("recommandé","conférence","Theatre","lecture","Categorie3","lecture4","Sport"));
        CategorieController adapter= new CategorieController(getContext(),list_categorie);
        recyclerView.setAdapter(adapter);
        adapter1 = new CentreController(getContext(),Centre.getallcentre(getContext()));
        RecyclerView recyclerViewcentre = (RecyclerView) view.findViewById(R.id.recyclercentre);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewcentre.setLayoutManager(layoutManager2);
        recyclerViewcentre.setAdapter(adapter1);





    }
}