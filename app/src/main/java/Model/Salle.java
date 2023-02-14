package Model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

import java.io.Serializable;

public class Salle implements Serializable {
    private int id_salle;
    private String numero_salle;
    private int etage_salle;
    private int capacite_salle;
    private String description_salle;
    private boolean disponibilite_salle;
    private byte[] image_salle;

    public int getId_salle() {
        return id_salle;
    }

    public String getNumero_salle() {
        return numero_salle;
    }

    public int getEtage_salle() {
        return etage_salle;
    }

    public int getCapacite_salle() {
        return capacite_salle;
    }

    public String getDescription_salle() {
        return description_salle;
    }

    public boolean isDisponibilite_salle() {
        return disponibilite_salle;
    }

    public byte[] getImage_salle() {
        return image_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public void setNumero_salle(String numero_salle) {
        this.numero_salle = numero_salle;
    }

    public void setEtage_salle(int etage_salle) {
        this.etage_salle = etage_salle;
    }

    public void setCapacite_salle(int capacite_salle) {
        this.capacite_salle = capacite_salle;
    }

    public void setDescription_salle(String description_salle) {
        this.description_salle = description_salle;
    }

    public void setDisponibilite_salle(boolean disponibilite_salle) {
        this.disponibilite_salle = disponibilite_salle;
    }

    public void setImage_salle(byte[] image_salle) {
        this.image_salle = image_salle;
    }

    public Salle(int id_salle, String numero_salle, int etage_salle, int capacite_salle, String description_salle, boolean disponibilite_salle, byte[] image_salle) {
        this.id_salle = id_salle;
        this.numero_salle = numero_salle;
        this.etage_salle = etage_salle;
        this.capacite_salle = capacite_salle;
        this.description_salle = description_salle;
        this.disponibilite_salle = disponibilite_salle;
        this.image_salle = image_salle;
    }
    public  Salle(){}
    public  Salle(int capacite , String numero_salle){
        this.capacite_salle= capacite;
        this.numero_salle= numero_salle;

    }

}
