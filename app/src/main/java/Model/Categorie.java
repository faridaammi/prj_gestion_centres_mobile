package Model;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.example.prj_gestion_centre_mobile.CentreFragment;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Categorie {
    final static String  url ="http://192.168.43.45:8000/api/getcategories";
    private int id_categorie;
    private String nom_categorie;

    public Categorie(int id_categorie, String nom_categorie) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
    }
    public Categorie (){}

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }
    public static ArrayList<Categorie> getallCategories(Context context){
        ArrayList<Categorie> list_categorie = new ArrayList<>();
        new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(new String(responseBody));
                    JSONArray jsonArray = new JSONArray(jsonObject.getString("Categories"));
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        Log.d("object",jsonObject1.toString());
                        Categorie categorie=new Categorie();
                        categorie.setId_categorie(Integer.parseInt(jsonObject1.getString("idCategorie")));
                        categorie.setNom_categorie(jsonObject1.getString("nomCategorie"));
                        list_categorie.add(categorie);
                        CentreFragment.adapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    Log.e("error ",e.getMessage());
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("error ",error.getMessage());
            }
        });
        return list_categorie;
    }
}
