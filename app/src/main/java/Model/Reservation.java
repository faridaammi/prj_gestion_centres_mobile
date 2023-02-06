package Model;

import java.util.Date;

public class Reservation {
    private static int Id_Reservation;
    private Date dateDebut_Reservation;
    private Date dateFin_Reservation;
    private Date date_Reservation;
    private String etats_Reservation;
    private String personne_invite;
    private String type_reservation;
    private String Description_reservation;

    public Reservation(Date date_Reservation, String etats_Reservation,String type_reservation ) {
        this.date_Reservation = date_Reservation;
        this.etats_Reservation = etats_Reservation;
        this.type_reservation=type_reservation;
    }
    public static int getId_Reservation() {
        return Id_Reservation;
    }

    public static void setId_Reservation(int id_Reservation) {
        Id_Reservation = id_Reservation;
    }

    public Date getDateDebut_Reservation() {
        return dateDebut_Reservation;
    }

    public Date getDateFin_Reservation() {
        return dateFin_Reservation;
    }

    public void setDateDebut_Reservation(Date dateDebut_Reservation) {
        this.dateDebut_Reservation = dateDebut_Reservation;
    }

    public void setDateFin_Reservation(Date dateFin_Reservation) {
        this.dateFin_Reservation = dateFin_Reservation;
    }

    public void setDate_Reservation(Date date_Reservation) {
        this.date_Reservation = date_Reservation;
    }

    public void setEtats_Reservation(String etats_Reservation) {
        this.etats_Reservation = etats_Reservation;
    }

    public void setPersonne_invite(String personne_invite) {
        this.personne_invite = personne_invite;
    }

    public void setDescription_reservation(String description_reservation) {
        Description_reservation = description_reservation;
    }

    public Date getDate_Reservation() {
        return date_Reservation;
    }

    public String getEtats_Reservation() {
        return etats_Reservation;
    }

    public String getPersonne_invite() {
        return personne_invite;
    }

    public String getDescription_reservation() {
        return Description_reservation;
    }

    public String getType_reservation() {
        return type_reservation;
    }

    public void setType_reservation(String type_reservation) {
        this.type_reservation = type_reservation;
    }
}

