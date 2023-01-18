package Model;

import java.util.Date;

public class Publication {
    private int imgv_profile;
    private String titre_publication;

    public Publication(int imgv_profile, String titre_publication, String date_pubilcation, String contenu_publication, int imgv_publication) {
        this.imgv_profile = imgv_profile;
        this.titre_publication = titre_publication;
        this.date_pubilcation = date_pubilcation;
        this.contenu_publication = contenu_publication;
        this.imgv_publication = imgv_publication;
    }

    private String date_pubilcation;
    private String contenu_publication;
    private int imgv_publication;

    public Publication(){}


    public int getImgv_profile() {
        return imgv_profile;
    }

    public void setImgv_profile(int imgv_profile) {
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

    public int getImgv_publication() {
        return imgv_publication;
    }

    public void setImgv_publication(int imgv_publication) {
        this.imgv_publication = imgv_publication;
    }
}