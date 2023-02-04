package com.example.prj_gestion_centre_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AccueilActivity extends AppCompatActivity {

    BottomNavigationView bottom_menu;

    AccueilFragment accueilFragment;
    CentreFragment centreFragment;
    FavorisFragment favorisFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        bottom_menu=findViewById(R.id.bottom_menu);
        accueilFragment=new AccueilFragment();
        centreFragment=new CentreFragment();
        favorisFragment=new FavorisFragment();
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
//                    case R.id.settingId:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.homeContainer,favorisFragment).commit();
//                        return true;
                }
                return false;
            }
        });

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(AccueilActivity.this,"notification");
        builder.setContentTitle("Attention");
        builder.setContentText("Matb9awch tpushiw les erreurs !");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(AccueilActivity.this);
        managerCompat.notify(1,builder.build());

    }


}