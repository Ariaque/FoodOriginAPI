package com.istic.foodorigin.domain;

import javax.persistence.*;

@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    public Label () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
