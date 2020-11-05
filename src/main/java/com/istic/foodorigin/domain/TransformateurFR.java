package com.istic.foodorigin.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Transformateur_FR")
public class TransformateurFR {

    @Id
    private Long id;
    private int departement;
    private long num_agrement;
    private String nom;
    private String adresse;
    private int code_postal;
    private String ville;
    private String activite;
    private String espece;
    private boolean est_premium;

    public TransformateurFR() {}

    public TransformateurFR(Long id, int department, long num_agrement, String nom, String adresse, int code_postal, String ville, String activite, String espece, boolean est_premium) {
        this.id = id;
        this.departement = department;
        this.num_agrement = num_agrement;
        this.nom = nom;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.ville = ville;
        this.activite = activite;
        this.espece = espece;
        this.est_premium = est_premium;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDepartment() {
        return departement;
    }

    public void setDepartment(int department) {
        this.departement = department;
    }

    public long getNum_agrement() {
        return num_agrement;
    }

    public void setNum_agrement(long num_agrement) {
        this.num_agrement = num_agrement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public boolean isEst_premium() {
        return est_premium;
    }

    public void setEst_premium(boolean est_premium) {
        this.est_premium = est_premium;
    }

    @Override
    public String toString() {
        return "Transformateur_FR{" +
                "id='" + id + '\'' +
                ", department=" + departement +
                ", num_agrement=" + num_agrement +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", code_postal=" + code_postal +
                ", ville='" + ville + '\'' +
                ", activite='" + activite + '\'' +
                ", espece='" + espece + '\'' +
                ", est_premium=" + est_premium +
                '}';
    }
}
