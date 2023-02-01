package com.example.prj_gestion_centre_mobile;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    Button btn_inscrer;
    EditText txt_num_organism,txt_email,txt_password,txt_conf_password;
    TextView txt_Sinscrire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn_inscrer = findViewById(R.id.btn_sidentifier);
        txt_num_organism = findViewById(R.id.IdNum_organisme);
        txt_email = findViewById(R.id.IdEmail_inscrire);
        txt_password = findViewById(R.id.IdPassword);
        txt_conf_password = findViewById(R.id.IdPassword_confirmer);
        txt_Sinscrire = findViewById(R.id.txt_Sinscrire);

        txt_Sinscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signUp.this,SignIn.class);
                startActivity(intent);
            }
        });
        btn_inscrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signUp.this,Verification_SignUp.class);
                    intent.putExtra("email",txt_email.getText().toString());
                    intent.putExtra("password",txt_password.getText().toString());
                    startActivity(intent);

            }
        });
    }
}