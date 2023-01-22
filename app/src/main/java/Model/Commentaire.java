package Model;

import java.util.Date;

public class Commentaire {
    private int id_cmnt;
    private String date_cmnt;
    private String contenu_cmnt;
    private  int id_utilisateur;

    public int getId_cmnt() {
        return id_cmnt;
    }

    public void setId_cmnt(int id_cmnt) {
        this.id_cmnt = id_cmnt;
    }

    public String getDate_cmnt() {
        return date_cmnt;
    }

    public void setDate_cmnt(String date_cmnt) {
        this.date_cmnt = date_cmnt;
    }

    public String getContenu_cmnt() {
        return contenu_cmnt;
    }

    public void setContenu_cmnt(String contenu_cmnt) {
        this.contenu_cmnt = contenu_cmnt;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public Commentaire(int id_cmnt, String date_cmnt, String contenu_cmnt, int id_utilisateur) {
        this.id_cmnt = id_cmnt;
        this.date_cmnt = date_cmnt;
        this.contenu_cmnt = contenu_cmnt;
        this.id_utilisateur = id_utilisateur;
    }
    public Commentaire(){}
}
