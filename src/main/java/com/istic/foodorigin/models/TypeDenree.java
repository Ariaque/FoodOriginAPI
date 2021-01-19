package com.istic.foodorigin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table (name = "foodOrigin_typeDenree")
public class TypeDenree {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String espece;
    private String animal;

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

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "TypeDenree{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", espece='" + espece + '\'' +
                ", animal='" + animal + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDenree that = (TypeDenree) o;
        return Objects.equals(nom, that.nom) &&
                Objects.equals(espece, that.espece) &&
                Objects.equals(animal, that.animal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, espece, animal);
    }
}
