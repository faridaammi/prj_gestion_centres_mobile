package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;

public class SignIn extends AppCompatActivity {
    final String url_login ="http://192.168.0.107:8000/api/login";
    public static String nom_organisme;
    Button btn_identifier;
    EditText txt_password,txt_email;
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
        txt_email = findViewById(R.id.IdEmail);
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
                if(validateEmail(txt_email)&& validatePassword()){
                    Signin();
                }
            }
        });
    }

    public boolean validateEmail(EditText emailtxt)
    {
        String emailInput = emailtxt.getText().toString();
        if(emailInput.isEmpty()){
            emailtxt.setError("Veuillez saisir votre email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            emailtxt.setError("Votre email est incorrect");
            return false;
        }
        else
        {
            return true;
        }
    }
    private boolean validatePassword() {
        String passwordInput = txt_password.getText().toString();
        if (passwordInput.isEmpty()) {
            txt_password.setError("Ce champs est obligatoire ");
            return false;
        }
        if (passwordInput.length() < 5) {
            txt_password.setError("le mot passe doit contenir au moins 5 caracteres");
            return false;
        } else {
            return true;
        }
    }
    public void Signin(){
        String emailInput = txt_email.getText().toString();
        password = txt_password.getText().toString();
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Login.....");
        dialog.show();
        try {
            RequestParams params= new RequestParams();
            params.put("Login",emailInput);
            params.put("Password",password);
            new AsyncHttpClient().get(url_login,params, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    try {
                        JSONObject object = new JSONObject(new String(responseBody));
                        Log.d("datass", object.toString());
                        dialog.dismiss();
                        if (object.getString("message").equals("Kayn had luser")){
                            JSONObject user = new JSONObject(object.getString("Utilisateur"));
                            nom_organisme=user.getString("nom_Organisme");
                            Intent intent = new Intent(SignIn.this,AccueilActivity.class);
                            intent.putExtra("ID_organisme",user.getString("id_Organisme"));
                            startActivity(intent);
                        }
                        else {
                            Log.d("makaynch", "makaynchhhh");
                            txt_email.setError("Cet utilisateur n'existe pas");

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Log.e("error",error.getMessage());
                }
            });
        }
        catch (Exception ex){
            Log.e("Error",ex.getMessage());
        }
    }
}
