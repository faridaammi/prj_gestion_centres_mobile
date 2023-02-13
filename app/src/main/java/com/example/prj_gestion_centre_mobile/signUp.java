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
    final static String url_SignUp = "http://192.168.0.121:8000/api/adduser";

    Button btn_inscrer;
    EditText txt_num_organism, txt_email, txt_password, txt_conf_password;
    TextView txt_Sinscrire, txt_password_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("S'inscrire");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        btn_inscrer = findViewById(R.id.btn_sidentifier);
        txt_num_organism = findViewById(R.id.IdNum_organisme);
        txt_email = findViewById(R.id.IdEmail_inscrire);
        txt_password = findViewById(R.id.IdPassword);
        txt_conf_password = findViewById(R.id.IdPassword_confirmer);
        txt_Sinscrire = findViewById(R.id.txt_Sinscrire);
        txt_password_error = findViewById(R.id.txt_pass_err);
        txt_Sinscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signUp.this, SignIn.class);
                startActivity(intent);
            }
        });
        btn_inscrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_password_error.setText("");
                if (validateEmail(txt_email)&&validatePassword()) {
                    adduser();
                }
            }
        });
    }

    public void adduser() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("S'inscrire en cours.....");
        dialog.show();
        String emailInput = txt_email.getText().toString();
        String passwordInput = txt_password.getText().toString();
        String code_organismeInput = txt_num_organism.getText().toString();
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
                        if (!object.getString("Message").equals("makaynach chi organisme bhad lcode")) {
                            Log.d("teste","wach dkhel lhna");

                            Intent intent = new Intent(signUp.this, Verification_SignUp.class);
                            intent.putExtra("email", txt_email.getText().toString());
                            intent.putExtra("password", txt_password.getText().toString());
                            startActivity(intent);
                        }
                        dialog.dismiss();
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Log.e("error", error.getMessage());
                    isvalid = false;
                }
            });
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }

    }

    public boolean validateEmail(EditText emailtxt)
    {
        String emailInput = emailtxt.getText().toString();
        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            return true;
        }
        else
        {
            txt_email.setError("Votre Email Incorrect");
            return false;
        }
    }
    private boolean validatePassword(){
        String passwordInput=txt_password.getText().toString();
        String confirm_passwordInput=txt_conf_password.getText().toString();
        if(passwordInput.isEmpty()){
            txt_password.setError("Ce champs est obligatoire ");
            return false;
        }
        if(passwordInput.length()<5){
            txt_password.setError("le mot passe doit contenir au moins 5 caracteres");
            return false;
        }
        if (!passwordInput.equals(confirm_passwordInput)){
            txt_conf_password.setError("le mot de passe de confirmation ne correspondent pas");
            return false;
        }
        else{
            return true;
        }
    }
}