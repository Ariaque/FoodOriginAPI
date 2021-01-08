package com.istic.foodorigin.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "foodOrigin_urlVideo")
public class UrlVideo {
    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private Long id;
    private String libelle;

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
        return "UrlVideo{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlVideo urlVideo = (UrlVideo) o;
        return Objects.equals(libelle, urlVideo.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle);
    }
}
