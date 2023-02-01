package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class remplissez_profil extends AppCompatActivity {

    AutoCompleteTextView list_type;
    EditText txt_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remplissez_profil);

        list_type = findViewById(R.id.typeOrganisme);
        String[] value = {"Sport","Arts","Etude","Developement"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,value);
        list_type.setAdapter(arrayAdapter);

        txt_email = findViewById(R.id.IdEmail_organisme);

        Intent intent = getIntent();
        txt_email.setText(intent.getExtras().get("email").toString());

    }
}