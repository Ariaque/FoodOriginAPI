package com.istic.foodorigin.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "foodOrigin_denreeAnimale")
public class DenreeAnimale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String origine;

    public DenreeAnimale () {}

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

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    @Override
    public String toString() {
        return "DenreeAnimale{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", origine='" + origine + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DenreeAnimale that = (DenreeAnimale) o;
        return Objects.equals(nom, that.nom) &&
                Objects.equals(origine, that.origine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, origine);
    }
}
