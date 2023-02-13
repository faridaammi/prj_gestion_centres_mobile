package Model;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.example.prj_gestion_centre_mobile.AccueilFragment;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import cz.msebera.android.httpclient.Header;

public class Publication {
    final static String  url ="http://192.168.1.8:8000/api/getpublication";

    private Bitmap imgv_profile;
    private String titre_publication;

    public Publication(Bitmap imgv_profile, String titre_publication, String date_pubilcation, String contenu_publication, Bitmap imgv_publication) {
        this.imgv_profile = imgv_profile;
        this.titre_publication = titre_publication;
        this.date_pubilcation = date_pubilcation;
        this.contenu_publication = contenu_publication;
        this.imgv_publication = imgv_publication;
    }
    private String date_pubilcation;
    private String contenu_publication;
    private Bitmap imgv_publication;

    public Publication(){}

    public Bitmap getImgv_profile() {
        return imgv_profile;
    }

    public void setImgv_profile(Bitmap imgv_profile) {
        this.imgv_profile = imgv_profile;
    }

    public String getTitre_publication() {
        return titre_publication;
    }

    public void setTitre_publication(String titre_publication) {
        this.titre_publication = titre_publication;
    }
    public String getDate_pubilcation() {
        return date_pubilcation;
    }

    public void setDate_pubilcation(String date_pubilcation) {
        this.date_pubilcation = date_pubilcation;
    }
    public String getContenu_publication() {
        return contenu_publication;
    }

    public void setContenu_publication(String contenu_publication) {
        this.contenu_publication = contenu_publication;
    }

    public Bitmap getImgv_publication() {
        return imgv_publication;
    }

    public void setImgv_publication(Bitmap imgv_publication) {
        this.imgv_publication = imgv_publication;
    }
    public static ArrayList<Publication> getAllPublication(Context context){
        ArrayList<Publication> list_publication = new ArrayList<>();
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("en cours de chargement");
        dialog.show();
        new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            try{
                JSONObject jsonObject = new JSONObject(new String(responseBody));
                JSONArray jsonArray = new JSONArray(jsonObject.getString("Publications"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    Log.d("object",jsonObject1.toString());
                    Publication publication=new Publication();
                    publication.setTitre_publication(jsonObject1.getString("titre_publication"));
                    publication.setContenu_publication(jsonObject1.getString("contenu_publication"));
                    String imageData = jsonObject1.getString("photo");
                    if (!imageData.equals("null")){
                        byte[] imageBytes = Base64.decode(imageData, Base64.DEFAULT);
                        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                        publication.setImgv_publication(decodedImage);
                    }
                    list_publication.add(publication);
                    AccueilFragment.adapter_publication.notifyDataSetChanged();
                    dialog.dismiss();

                }
                }
            catch (Exception e){
                Log.e("Error",e.getMessage());
            }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("Error ",error.getMessage());

            }
        });
        return list_publication;
    }
}