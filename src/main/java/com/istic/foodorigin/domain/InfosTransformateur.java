package com.istic.foodorigin.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class InfosTransformateur {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String nombre_employes;
    private String url_site;
    private String url_facebook;
    private String url_twitter;
    private String url_instagram;
    private boolean appartient_groupe;
    @OneToOne
    @JoinColumn (name = "fk_groupe")
    private Transformateur fk_groupe;
    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable (name = "infos_transformateur_label",
                joinColumns = @JoinColumn (name = "fk_infos"),
                inverseJoinColumns = @JoinColumn (name = "fk_label"))
    private Set<Label> labels;

    public InfosTransformateur () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNombre_employes() {
        return nombre_employes;
    }

    public void setNombre_employes(String nombre_employes) {
        this.nombre_employes = nombre_employes;
    }

    public String getUrl_site() {
        return url_site;
    }

    public void setUrl_site(String url_site) {
        this.url_site = url_site;
    }

    public String getUrl_facebook() {
        return url_facebook;
    }

    public void setUrl_facebook(String url_facebook) {
        this.url_facebook = url_facebook;
    }

    public String getUrl_twitter() {
        return url_twitter;
    }

    public void setUrl_twitter(String url_twitter) {
        this.url_twitter = url_twitter;
    }

    public String getUrl_instagram() {
        return url_instagram;
    }

    public void setUrl_instagram(String url_instagram) {
        this.url_instagram = url_instagram;
    }

    public boolean isAppartient_groupe() {
        return appartient_groupe;
    }

    public void setAppartient_groupe(boolean appartient_groupe) {
        this.appartient_groupe = appartient_groupe;
    }

    public Transformateur getFk_groupe() {
        return fk_groupe;
    }

    public void setFk_groupe(Transformateur fk_groupe) {
        this.fk_groupe = fk_groupe;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "InfosTransformateur{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", nombre_employes='" + nombre_employes + '\'' +
                ", url_site='" + url_site + '\'' +
                ", url_facebook='" + url_facebook + '\'' +
                ", url_twitter='" + url_twitter + '\'' +
                ", url_instagram='" + url_instagram + '\'' +
                ", appartient_groupe=" + appartient_groupe +
                ", fk_groupe=" + fk_groupe +
                ", labels=" + labels.toString() +
                '}';
    }
}
