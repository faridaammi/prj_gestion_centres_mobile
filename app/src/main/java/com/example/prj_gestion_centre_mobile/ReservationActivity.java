package com.example.prj_gestion_centre_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import Controller.Salle_Controller;
import Model.Centre;
import Model.Salle;

import Controller.Salle_Controller;
import Model.Centre;
import Model.Salle;
import cz.msebera.android.httpclient.Header;

public class ReservationActivity extends AppCompatActivity{
    final String url="http://192.168.43.45:8000/api/addreservation";
    CalendarView calendarView;
    RecyclerView recyclerView;
    TextView datedepart, datefin, txtinvite;
    Button btn_addinvite,btn_deleteinvite,btn_reserver ;
    int comptinvite=0;
    Context context = this;
    RadioGroup radio_group_date;
    String datedebut,date_fin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent centreintent = getIntent();
        Centre centre =(Centre) centreintent.getSerializableExtra("Centre");
        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        setContentView(R.layout.activity_reservation);
        btn_addinvite = (Button) findViewById(R.id.btnaddinvite);
        btn_deleteinvite=(Button)findViewById(R.id.btndeleteinvite);
        btn_reserver=(Button)findViewById(R.id.btn_Continue);
        calendarView= (CalendarView) findViewById(R.id.calendarView);
        datedepart= (TextView) findViewById(R.id.txt_datedepart);
        datefin = (TextView) findViewById(R.id.txt_datefin);
        txtinvite = (TextView) findViewById(R.id.txt_invite);
        radio_group_date= (RadioGroup) findViewById(R.id.radio_group_date);
        recyclerView = (RecyclerView) findViewById(R.id.rceyclesalle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        Salle_Controller salleController = new Salle_Controller(this,centre.getSalles_centre());
        recyclerView.setAdapter(salleController);
        datedepart.setText(new SimpleDateFormat("MMM").format(new Date())+new SimpleDateFormat("D").format(new Date()));
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                SimpleDateFormat monthParse = new SimpleDateFormat("MM");
                SimpleDateFormat monthDisplay = new SimpleDateFormat("MMM");

                try {
                    if(radio_group_date.getCheckedRadioButtonId()==R.id.rb_date_debut){
                        datedebut =  String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth);
                        datedepart.setText( monthDisplay.format(monthParse.parse(String.valueOf(month+1)))+" "+String.valueOf(dayOfMonth));
                    }else{
                        date_fin=  String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth);
                        datefin.setText( monthDisplay.format(monthParse.parse(String.valueOf(month+1)))+" "+String.valueOf(dayOfMonth));
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog dialog = new ProgressDialog(context);
                dialog.setMessage("en cours de chargement");
                dialog.show();
                try {
                    RequestParams params = new RequestParams();
                    params.put("datedebut",datedebut);
                    params.put("datefin",date_fin);
                    params.put("type","");
                    params.put("nbrinvitee",txtinvite.getText());
                    params.put("description","");
                    params.put("idorganisme",SignIn.id_organisme);
                    Log.d("offf", TextUtils.join(",", getselectdidsalle()));
                    params.put("id_sallesreserver", TextUtils.join(",",getselectdidsalle()));
                    new AsyncHttpClient().post(url, params, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            try {
                                JSONObject object = new JSONObject(new String(responseBody));
                                Log.d("nchofo", object.toString());
                                if (object.getString("Message").equals("Reservation bien été ajouter")) {
                                    dialog.dismiss();
                                    Intent intent = new Intent(getApplicationContext(),ReservationdetailsActivity.class);
                                    startActivity(intent);
                                }
                                else {
                                    Log.d("Error api ",object.getString("Message"));
                                    Toast.makeText(getApplicationContext(),"Error dans l'insertion de reservation",Toast.LENGTH_LONG).show();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            Log.e("Errorrr",error.getMessage());

                        }
                    });



                } catch (Exception ex){
                    Log.e("Error",ex.getMessage());
                }
            }
        });


    }



    public void deleteinvite(View view) {
        comptinvite--;
        comptinvite = comptinvite<0?0:comptinvite;
        txtinvite.setText(String.valueOf(comptinvite));
    }

    public void addinvite(View view) {
        comptinvite++;
        txtinvite.setText(String.valueOf(comptinvite));

    }
    public ArrayList<Integer> getselectdidsalle(){
        ArrayList<Integer> ids_salles = new ArrayList<>();
        for (Salle salle: Salle_Controller.select_item_salle) {
            ids_salles.add(salle.getId_salle());
        }
        return ids_salles;
    }

}