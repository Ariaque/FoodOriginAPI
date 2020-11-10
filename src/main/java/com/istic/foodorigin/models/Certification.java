package com.istic.foodorigin.models;

import javax.persistence.*;

@Entity
@Table (name = "certification")
public class Certification {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    public Certification () {}

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
        return "Certification{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
