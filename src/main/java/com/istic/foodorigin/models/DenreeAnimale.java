package com.istic.foodorigin.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class mapping "foodOrigin_denreeAnimale" table of the database.
 */
@Entity
@Table(name = "foodOrigin_denreeAnimale")
public class DenreeAnimale {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "fk_type")
    private TypeDenree typeDenree;
    @OneToOne
    @JoinColumn(name = "fk_origine")
    private OrigineDenree origineDenree;
    private String infosTypeDenree;
    private String infosOrigineDenree;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeDenree getTypeDenree() {
        return typeDenree;
    }

    public void setTypeDenree(TypeDenree typeDenree) {
        this.typeDenree = typeDenree;
    }

    public OrigineDenree getOrigineDenree() {
        return origineDenree;
    }

    public void setOrigineDenree(OrigineDenree origineDenree) {
        this.origineDenree = origineDenree;
    }

    public String getInfosTypeDenree() {
        return infosTypeDenree;
    }

    public void setInfosTypeDenree(String infosTypeDenree) {
        this.infosTypeDenree = infosTypeDenree;
    }

    public String getInfosOrigineDenree() {
        return infosOrigineDenree;
    }

    public void setInfosOrigineDenree(String infosOrigineDenree) {
        this.infosOrigineDenree = infosOrigineDenree;
    }

    @Override
    public String toString() {
        return "DenreeAnimal{" +
                "id=" + id +
                ", typeDenree=" + typeDenree +
                ", origineDenree=" + origineDenree +
                ", infosTypeDenree='" + infosTypeDenree + '\'' +
                ", infosOrigineDenree='" + infosOrigineDenree + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DenreeAnimale that = (DenreeAnimale) o;
        return Objects.equals(typeDenree, that.typeDenree) &&
                Objects.equals(origineDenree, that.origineDenree) &&
                Objects.equals(infosTypeDenree, that.infosTypeDenree) &&
                Objects.equals(infosOrigineDenree, that.infosOrigineDenree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeDenree, origineDenree, infosTypeDenree, infosOrigineDenree);
    }
}
