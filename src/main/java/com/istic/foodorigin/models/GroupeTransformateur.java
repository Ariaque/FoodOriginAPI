package com.istic.foodorigin.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "foodOrigin_groupeTransformateur")

public class GroupeTransformateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "foodOrigin_groupeTransformateur_label",
            joinColumns = @JoinColumn(name = "fk_infos"),
            inverseJoinColumns = @JoinColumn(name = "fk_label"))
    private Set<Label> labels;

    private String description;

    @OneToMany
    private Set<Transformateur> transformateurs;

    public GroupeTransformateur() {
        this.labels = new HashSet<>();
        this.transformateurs = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public void addLabel(Label label) {
        labels.add(label);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Transformateur> getTransformateurs() {
        return transformateurs;
    }

    public void setTransformateurs(Set<Transformateur> transformateurs) {
        this.transformateurs = transformateurs;
    }
}
