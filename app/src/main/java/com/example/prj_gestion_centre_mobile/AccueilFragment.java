package com.example.prj_gestion_centre_mobile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import Controller.AccueilController;
import Model.Publication;

public class AccueilFragment extends Fragment {

    private RecyclerView recyclerViewPub;
    private List<Publication> listItems;
    LinearLayoutManager layoutManager;
    private RecyclerView.Adapter adapterPublication;
    public AccueilFragment() {
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
        return inflater.inflate(R.layout.fragment_accueil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewPub = view.findViewById(R.id.recyclerViewPub);
        layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewPub.setLayoutManager(layoutManager);
        recyclerViewPub.setHasFixedSize(true);
        //recyclerViewPub.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        Publication items1 =new Publication(R.drawable.icon_profile,"CEFT IBN ZOHR - TIZNIT","12/01/2023","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here,",R.drawable.img_publication);
        Publication items2 =new Publication(R.drawable.icon_profile2,"Centre Med khair eddin","22/12/2022","بدأ العد التنازلي للمهرجان الدولي للمسرح والثقافات... نتلاقاو فالمسرح.",R.drawable.img_pub2);

        listItems.add(items1);
        listItems.add(items2);

        adapterPublication=new AccueilController(getContext(),listItems);
        recyclerViewPub.setAdapter(adapterPublication);
        adapterPublication.notifyDataSetChanged();
    }
}