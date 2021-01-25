package com.istic.foodorigin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Class mapping "foodOrigin_origineDenree" table of the database.
 */
@Entity
@Table(name = "foodOrigin_origineDenree")
public class OrigineDenree {
    @Id
    @GeneratedValue
    private Long id;
    private String pays;
    private String region;

    public OrigineDenree() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "OrigineDenree{" +
                "id=" + id +
                ", pays='" + pays + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrigineDenree that = (OrigineDenree) o;
        return Objects.equals(pays, that.pays) &&
                Objects.equals(region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pays, region);
    }
}
