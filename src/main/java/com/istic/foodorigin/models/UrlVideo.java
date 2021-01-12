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
    private String titre;

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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "UrlVideo{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlVideo urlVideo = (UrlVideo) o;
        return Objects.equals(libelle, urlVideo.libelle) &&
                Objects.equals(titre, urlVideo.titre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle, titre);
    }
}
