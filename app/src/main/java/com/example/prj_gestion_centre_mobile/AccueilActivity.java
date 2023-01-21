package com.example.prj_gestion_centre_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AccueilActivity extends AppCompatActivity {

    BottomNavigationView bottom_menu;

    AccueilFragment accueilFragment;
    CentreFragment centreFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        bottom_menu=findViewById(R.id.bottom_menu);
        accueilFragment=new AccueilFragment();
        centreFragment=new CentreFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer,accueilFragment).commit();
        bottom_menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeId:
                        getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer,accueilFragment).commit();
                        return true;
                    case R.id.centreId:
                        getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer,centreFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }


}