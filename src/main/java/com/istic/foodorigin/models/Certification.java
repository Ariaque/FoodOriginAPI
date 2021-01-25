package com.istic.foodorigin.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class mapping "foodOrigin_certification" table of the database.
 */
@Entity
@Table(name = "foodOrigin_certification")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    public Certification() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certification that = (Certification) o;
        return Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle);
    }
}
