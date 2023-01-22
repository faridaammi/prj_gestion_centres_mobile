package Model;

public class Salle {
    private int id_salle;
    private String numero_salle;
    private int etage_salle;
    private int capacite_salle;
    private String description_salle;
    private boolean disponibilite_salle;
    private int image_salle;

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

    public int getImage_salle() {
        return image_salle;
    }

    public Salle(int id_salle, String numero_salle, int etage_salle, int capacite_salle, String description_salle, boolean disponibilite_salle, int image_salle) {
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
