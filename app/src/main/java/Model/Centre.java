package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Centre implements Serializable {
    private int id_centre;
    private String nom_centre;
    private String adresse_centre;
    private String descriptioncentre;
    private Boolean favoris_centre;
    private int img_centre;
    private ArrayList<Integer> imgs_centre;
    private ArrayList<Salle> salles_centre;

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

    public ArrayList<Integer> getImgs_centre() {
        return imgs_centre;
    }

    public void setImgs_centre(ArrayList<Integer> imgs_centre) {
        this.imgs_centre = imgs_centre;
    }

    public int getImg_centre() {
        return img_centre;
    }

    public void setImg_centre(int img_centre) {
        this.img_centre = img_centre;
    }
    public Centre(int id_centre, String nom_centre, String adresse_centre, String descriptioncentre, ArrayList<Integer> imgs_centre) {
        this.id_centre = id_centre;
        this.nom_centre = nom_centre;
        this.adresse_centre = adresse_centre;
        this.descriptioncentre = descriptioncentre;
        this.imgs_centre = imgs_centre;
    }
    //pour les centres favoris:
    public Centre(String nom_centre,int img_centre) {
        this.nom_centre = nom_centre;
        this.img_centre = img_centre;
    }
    public Centre(){  }
}
