package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignIn extends AppCompatActivity {

    Button btn_identifier;
    EditText txt_password,txt_username;
    TextView txt_Sinscrire;
    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("S'identifier");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);



        btn_identifier = findViewById(R.id.btn_sidentifier);
        txt_username = findViewById(R.id.IdEmail);
        txt_password = findViewById(R.id.IdPassword);
        txt_Sinscrire = findViewById(R.id.txt_Sinscrire);

        txt_Sinscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this,signUp.class);
                startActivity(intent);
            }
        });

        btn_identifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validateEmail(txt_username);
            }
        });
//        Intent intent = getIntent();
////        email = intent.getStringExtra("email");
////        password = intent.getStringExtra("password");
//        txt_username.setText(intent.getExtras().get("email").toString());
//        txt_password.setText(intent.getExtras().get("password").toString());
    }
    public boolean validateEmail(EditText emailtxt)
    {
        String emailInput = emailtxt.getText().toString();
        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            Intent intent = new Intent(SignIn.this,AccueilActivity.class);
            intent.putExtra("username",txt_username+"");
            intent.putExtra("password",txt_password+"");
            startActivity(intent);
            return true;
        }
        else
        {

            Toast tost = Toast.makeText(this,"Votre Email Incorrect",Toast.LENGTH_SHORT);
            tost.show();
            return false;
        }
    }
}
