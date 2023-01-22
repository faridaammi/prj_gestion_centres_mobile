package Model;

import com.example.prj_gestion_centre_mobile.Centre_details_activity;

import java.util.ArrayList;
import java.util.Date;

public class Utilisateur {
    private int id_utilisateur;
    private String motdepass_utilisateur;
    private String nom_utilisateur;
    private String adresse;
    private String email_utilisateur;
    private int tele_utilisateur;
    private int etat_utilisateur;
    private Date date_de_creation;
    private Date date_de_validation;
    private int IP_utilisateur;
    private long token;
    private int img_utilisateur;

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public String getMotdepass_utilisateur() {
        return motdepass_utilisateur;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail_utilisateur() {
        return email_utilisateur;
    }

    public int getTele_utilisateur() {
        return tele_utilisateur;
    }

    public int getEtat_utilisateur() {
        return etat_utilisateur;
    }

    public int getImg_utilisateur() {
        return img_utilisateur;
    }

    public void setImg_utilisateur(int img_utilisateur) {
        this.img_utilisateur = img_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setMotdepass_utilisateur(String motdepass_utilisateur) {
        this.motdepass_utilisateur = motdepass_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail_utilisateur(String email_utilisateur) {
        this.email_utilisateur = email_utilisateur;
    }

    public void setTele_utilisateur(int tele_utilisateur) {
        this.tele_utilisateur = tele_utilisateur;
    }

    public void setEtat_utilisateur(int etat_utilisateur) {
        this.etat_utilisateur = etat_utilisateur;
    }

    public void setDate_de_creation(Date date_de_creation) {
        this.date_de_creation = date_de_creation;
    }

    public void setDate_de_validation(Date date_de_validation) {
        this.date_de_validation = date_de_validation;
    }

    public void setIP_utilisateur(int IP_utilisateur) {
        this.IP_utilisateur = IP_utilisateur;
    }

    public void setToken(long token) {
        this.token = token;
    }

    public Date getDate_de_creation() {
        return date_de_creation;
    }

    public Date getDate_de_validation() {
        return date_de_validation;
    }

    public int getIP_utilisateur() {
        return IP_utilisateur;
    }

    public long getToken() {
        return token;
    }



    public Utilisateur(int id_utilisateur, String motdepass_utilisateur, String nom_utilisateur, String adresse, String email_utilisateur, int tele_utilisateur, int etat_utilisateur, Date date_de_creation, Date date_de_validation, int IP_utilisateur, long token) {
        this.id_utilisateur = id_utilisateur;
        this.motdepass_utilisateur = motdepass_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.adresse = adresse;
        this.email_utilisateur = email_utilisateur;
        this.tele_utilisateur = tele_utilisateur;
        this.etat_utilisateur = etat_utilisateur;
        this.date_de_creation = date_de_creation;
        this.date_de_validation = date_de_validation;
        this.IP_utilisateur = IP_utilisateur;
        this.token = token;
    }
    public Utilisateur (int id_utilisateur,String nom_utilisateur,int img_utilisateur){
        this.id_utilisateur = id_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.img_utilisateur=img_utilisateur;

    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id_utilisateur=" + id_utilisateur +
                ", motdepass_utilisateur='" + motdepass_utilisateur + '\'' +
                ", nom_utilisateur='" + nom_utilisateur + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email_utilisateur='" + email_utilisateur + '\'' +
                ", tele_utilisateur=" + tele_utilisateur +
                ", etat_utilisateur=" + etat_utilisateur +
                ", date_de_creation=" + date_de_creation +
                ", date_de_validation=" + date_de_validation +
                ", IP_utilisateur=" + IP_utilisateur +
                ", token=" + token +
                '}';
    }
    public static Utilisateur finduser(int id){
        Utilisateur utilisateur = null;
        for(Utilisateur user : Centre_details_activity.list){
            if (user.getId_utilisateur()==id){
                utilisateur= user;
                break;
            }
        }
        return utilisateur;
    }
}
