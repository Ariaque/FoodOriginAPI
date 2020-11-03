package com.istic.foodorigin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Infos_Transformateur {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private int nombre_employes;
    private String url_facebook;
    private String url_twitter;
    private String url_instagram;
    private boolean appartient_groupe;

}
