package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Verification_SignUp extends AppCompatActivity {

    TextView txt_email;
    Button btn_next;
    EditText txt_1,txt_2,txt_3,txt_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_sign_up);

        txt_email = findViewById(R.id.txt_email);
        String email;

        Intent intent = getIntent();
        txt_email.setText("Nous vous avons envoyé le code de vérification au "+intent.getExtras().get("email").toString());
        email = intent.getExtras().get("email").toString();
        btn_next = findViewById(R.id.btn_continue);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent1 = new Intent(Verification_SignUp.this,remplissez_profil.class);
                    intent1.putExtra("email",email);
                    startActivity(intent1);
            }
        });


    }
}