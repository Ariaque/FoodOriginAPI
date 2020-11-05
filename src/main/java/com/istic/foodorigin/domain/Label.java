package com.istic.foodorigin.domain;

import javax.persistence.*;

@Entity
@Table (name = "label")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;
    @Column (name = "libelle")
    private String libelle;

    public Label () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
