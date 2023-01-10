package com.istic.foodorigin.models;

import javax.persistence.*;

/**
 * Class mapping "foodOrigin_transformateur" table of the database.
 */
@Entity
@Table(name = "foodOrigin_transformateur")
public class Transformateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "num_agrement")
    private String numAgrement;
    private String siret;
    private String raison_sociale;
    private String adresse;
    private String code_postal;
    private String commune;
    private String categorie;
    private String act_associees;
    private String espece;
    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "groupe_transformateur_id")
    private GroupeTransformateur groupeTransformateur;

    public Transformateur() {
    }

    public GroupeTransformateur getGroupeTransformateur() {
        return groupeTransformateur;
    }

    public void setGroupeTransformateur(GroupeTransformateur groupeTransformateur) {
        this.groupeTransformateur = groupeTransformateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum_agrement() {
        return numAgrement;
    }

    public void setNum_agrement(String num_agrement) {
        this.numAgrement = num_agrement;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getRaison_sociale() {
        return raison_sociale;
    }

    public void setRaison_sociale(String raison_sociale) {
        this.raison_sociale = raison_sociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getAct_associees() {
        return act_associees;
    }

    public void setAct_associees(String act_associees) {
        this.act_associees = act_associees;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


}
