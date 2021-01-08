package com.istic.foodorigin.models;

import javax.persistence.*;

@Entity
@Table(name = "foodOrigin_fermePartenaire")
public class FermePartenaire {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String description;

    public FermePartenaire () {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FermePartenaire{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
