package com.istic.foodorigin.models;

import javax.persistence.*;

@Entity
@Table (name = "foodOrigin_typeTransformateur")
public class TypeTransformateur {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    public TypeTransformateur() {}

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
        return "Type_Transformateur{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
