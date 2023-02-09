package com.example.prj_gestion_centre_mobile;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class remplissez_profil extends AppCompatActivity {

    AutoCompleteTextView list_type;
    EditText txt_email,dt_creation;
    CircleImageView logo;
    ImageButton edite_pic;
    TextView title;

    private final int CAMERA_REQ_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_remplissez_profil);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Remplissez votre profil");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        list_type = findViewById(R.id.typeOrganisme);
        String[] value = {"Sport","Arts","Etude","Developement"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,value);
        list_type.setAdapter(arrayAdapter);


        txt_email = findViewById(R.id.IdEmail_organisme);
        dt_creation = findViewById(R.id.date_creation);
        logo = findViewById(R.id.profile_image);
        edite_pic = findViewById(R.id.btn_update_pic);

//        Intent intent = getIntent();
//        txt_email.setText(intent.getExtras().get("email").toString());

        final Calendar myCalendar = Calendar.getInstance();
        final int year = myCalendar.get(Calendar.YEAR);
        final int month = myCalendar.get(Calendar.MONTH);
        final int day = myCalendar.get(Calendar.DAY_OF_MONTH);

        dt_creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(remplissez_profil.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        String date = day+" - "+month+" - "+year;
                        dt_creation.setText(date);
                    }
                },year, month, day);
                dialog.show();
            }
        });

        edite_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCam = new Intent(Intent.ACTION_PICK);
                intentCam.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentCam,CAMERA_REQ_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            if(requestCode == CAMERA_REQ_CODE)
            {
                logo.setImageURI(data.getData());
            }
        }
    }
}