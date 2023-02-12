package com.example.prj_gestion_centre_mobile;

import androidx.activity.result.contract.ActivityResultContracts;
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

import Model.Utilisateur;
import cz.msebera.android.httpclient.Header;

public class signUp extends AppCompatActivity {
    final static String url_SignUp = "http://192.168.1.8:8000/api/adduser";

    Button btn_inscrer;
    EditText txt_num_organism,txt_email,txt_password,txt_conf_password;
    TextView txt_Sinscrire,txt_password_error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("S'inscrire");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        btn_inscrer = findViewById(R.id.btn_sidentifier);
        txt_num_organism = findViewById(R.id.IdNum_organisme);
        txt_email = findViewById(R.id.IdEmail_inscrire);
        txt_password = findViewById(R.id.IdPassword);
        txt_conf_password = findViewById(R.id.IdPassword_confirmer);
        txt_Sinscrire = findViewById(R.id.txt_Sinscrire);
        txt_password_error=findViewById(R.id.txt_pass_err);
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
                if(validateEmail(txt_email) && validatePassword())
                {
                    Intent intent = new Intent(signUp.this,Verification_SignUp.class);
                    intent.putExtra("email",txt_email.getText().toString());
                    intent.putExtra("password",txt_password.getText().toString());
                    startActivity(intent);
                }

            }
        });
    }
    public boolean validateEmail(EditText emailtxt)
    {
        String emailInput = emailtxt.getText().toString();
        String passwordInput= txt_password.getText().toString();
        String code_organismeInput=txt_num_organism.getText().toString();
        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            ProgressDialog dialog = new ProgressDialog(this);
            dialog.setMessage("S'inscrire en cours.....");
            dialog.show();

            try {
                RequestParams params = new RequestParams();
                params.put("email", emailInput);
                params.put("password", passwordInput);
                params.put("code_organisme", code_organismeInput);
                new AsyncHttpClient().post(url_SignUp, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        try {
                            JSONObject object = new JSONObject(new String(responseBody));
                            Log.d("l'utilisateur a été bien ajouté", object.toString());
                            dialog.dismiss();
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.e("error",error.getMessage());
                    }
                });
            }catch (Exception e){
                Log.e("Error",e.getMessage());
            }

            return true;
        }
        else
        {
            Toast tost = Toast.makeText(this,"Votre Email Incorrect",Toast.LENGTH_SHORT);
            tost.show();
            return false;
        }
    }
    private boolean validatePassword(){
        String passwordInput=txt_password.getText().toString();
        String confirm_passwordInput=txt_conf_password.getText().toString();
        if(passwordInput.isEmpty()){
            txt_password_error.setText("Ce champs est obligatoire ");
            return false;
        }
        if(passwordInput.length()<5){
            txt_password_error.setText("le mot passe doit contenir au moins 5 caracteres");
            return false;
        }
        if (!passwordInput.equals(confirm_passwordInput)){
            txt_password_error.setText("le mot de passe de confirmation ne correspondent pas");
            return false;
        }
        else{
            return true;
        }
    }
}