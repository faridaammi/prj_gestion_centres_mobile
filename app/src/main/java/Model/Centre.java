package Model;


import android.app.ProgressDialog;
import android.content.Context;
import android.util.Base64;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.prj_gestion_centre_mobile.CentreFragment;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class Centre implements Serializable {
    final static String  url ="http://192.168.0.107:8000/api/getcentre";
    private int id_centre;
    private String nom_centre;
    private String adresse_centre;
    private String descriptioncentre;
    private Boolean favoris_centre;
//    private byte[] img_centre;
    private ArrayList<byte[]> imgs_centre = new ArrayList<>();;
    private ArrayList<Salle> salles_centre;

    public void setImgs_centre(ArrayList<byte[]> imgs_centre) {
        this.imgs_centre = imgs_centre;
    }

    public ArrayList<byte[]> getImgs_centre() {
        return imgs_centre;
    }

    public int getId_centre() {
        return id_centre;
    }

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

    public String getNom_centre() {
        return nom_centre;
    }

    public void setNom_centre(String nom_centre) {
        this.nom_centre = nom_centre;
    }

    public String getAdresse_centre() {
        return adresse_centre;
    }

    public void setAdresse_centre(String adresse_centre) {
        this.adresse_centre = adresse_centre;
    }

    public String getDescriptioncentre() {
        return descriptioncentre;
    }
    public Boolean getFavoris_centre() { return favoris_centre; }

    public void setFavoris_centre(Boolean favoris_centre) { this.favoris_centre = favoris_centre; }

    public ArrayList<Salle> getSalles_centre() {
        return salles_centre;
    }

    public void setSalles_centre(ArrayList<Salle> salles_centre) {
        this.salles_centre = salles_centre;
    }

    public void setDescriptioncentre(String descriptioncentre) {
        this.descriptioncentre = descriptioncentre;
    }



//    public byte[] getImg_centre() {
//        return img_centre;
    //}

  //  public void setImg_centre(byte[] img_centre) {
  //      this.img_centre = img_centre;
   // }
    public Centre(int id_centre, String nom_centre, String adresse_centre, String descriptioncentre, ArrayList<byte[]> imgs_centre) {
        this.id_centre = id_centre;
        this.nom_centre = nom_centre;
        this.adresse_centre = adresse_centre;
        this.descriptioncentre = descriptioncentre;
        this.imgs_centre = imgs_centre;
    }
    //pour les centres favoris:
    public Centre(String nom_centre,byte[] img_centre) {
        this.nom_centre = nom_centre;
      //  this.img_centre = img_centre;
    }
    public Centre(){  }


    public static ArrayList<Centre> getallcentre(Context context){
        ArrayList<Centre> centres = new ArrayList<>();
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("en cours de chargement");
        dialog.show();

        new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String responseString = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(responseString);
                    JSONArray jsonArray = new JSONArray(jsonObject.getString("Centres"));
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        Log.d("object",jsonObject1.toString());
                        Centre centre = new Centre();
                        centre.setId_centre(Integer.valueOf(jsonObject1.getString("idCentre")));
                        centre.setNom_centre(jsonObject1.getString("nomCentre"));
                        centre.setAdresse_centre(jsonObject1.getString("adresseCentre"));
                        centre.setDescriptioncentre(jsonObject1.getString("descriptionCentre"));
                        JSONArray Images = new JSONArray(jsonObject1.getString("images"));
                        if (Images.length()>0){
                            for (int j =0;j<Images.length();j++){
                                String imageData =String.valueOf(Images.get(j));
                                Log.d("ddd",imageData);
                                byte[] imageBytes = Base64.decode(imageData, Base64.DEFAULT);
                                //Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                                centre.imgs_centre.add(imageBytes);


                            }

                        }



                        //    centre.setImg_centre(R.drawable.img_dartaqafa);
                        centres.add(centre);
                        CentreFragment.adapter1.notifyDataSetChanged();
                        dialog.dismiss();

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
        return  centres;

    }
}
