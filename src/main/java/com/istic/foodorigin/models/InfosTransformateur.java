package com.istic.foodorigin.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "foodOrigin_infosTransformateur")
public class InfosTransformateur {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn (name = "fk_transformateur")
    private Transformateur transformateur;
    private String description;
    private String nombre_employes;
    private String url_site;
    private String url_facebook;
    private String url_twitter;
    private String url_instagram;
    private boolean appartient_groupe;
    private String siret_groupe;
    @ManyToMany
    @JoinTable (name = "foodOrigin_infosTransformateur_label",
                joinColumns = @JoinColumn (name = "fk_infos"),
                inverseJoinColumns = @JoinColumn (name = "fk_label"))
    private Set<Label> labels;
    @ManyToMany
    @JoinTable (name = "foodOrigin_infosTransformateur_certification",
                joinColumns = @JoinColumn(name = "fk_infos"),
                inverseJoinColumns = @JoinColumn (name = "fk_certification"))
    private Set <Certification> certifications;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "foodOrigin_infosTransformateur_urlVideo",
            joinColumns = @JoinColumn(name = "fk_infos"),
            inverseJoinColumns = @JoinColumn (name = "fk_urls"))
    private Set <UrlVideo> urls;
    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable (name = "foodOrigin_infosTransformateur_fermePartenaire",
            joinColumns = @JoinColumn(name = "fk_infos"),
            inverseJoinColumns = @JoinColumn (name = "fk_fermesP"))
    private Set <FermePartenaire> fermesP;


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

    public String getSiret_groupe() {
        return siret_groupe;
    }

    public void setSiret_groupe(String siret_groupe) {
        this.siret_groupe = siret_groupe;
    }

    public boolean isAppartient_groupe() {
        return appartient_groupe;
    }

    public void setAppartient_groupe(boolean appartient_groupe) {
        this.appartient_groupe = appartient_groupe;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public Transformateur getTransformateur() {
        return transformateur;
    }

    public void setTransformateur(Transformateur transformateur) {
        this.transformateur = transformateur;
    }

    public Set<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(Set<Certification> certifications) {
        this.certifications = certifications;
    }

    public Set<UrlVideo> getUrls() {
        return urls;
    }

    public void setUrls(Set<UrlVideo> urls) {
        this.urls = urls;
    }

    public Set<FermePartenaire> getFermesP() {
        return fermesP;
    }

    public void setFermesP(Set<FermePartenaire> fermesP) {
        this.fermesP = fermesP;
    }

    @Override
    public String toString() {
        return "InfosTransformateur{" +
                "id=" + id +
                ", transformateur=" + transformateur +
                ", description='" + description + '\'' +
                ", nombre_employes='" + nombre_employes + '\'' +
                ", url_site='" + url_site + '\'' +
                ", url_facebook='" + url_facebook + '\'' +
                ", url_twitter='" + url_twitter + '\'' +
                ", url_instagram='" + url_instagram + '\'' +
                ", appartient_groupe=" + appartient_groupe +
                ", siret_groupe='" + siret_groupe + '\'' +
                ", labels=" + labels +
                ", certifications=" + certifications +
                ", urls=" + urls +
                ", fermesP=" + fermesP +
                '}';
    }
}
