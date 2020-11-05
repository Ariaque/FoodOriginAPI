package com.istic.foodorigin.domain;

import javax.persistence.*;

@Entity
@Table (name = "Infos_Transformateur")
public class InfosTransformateur {

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
