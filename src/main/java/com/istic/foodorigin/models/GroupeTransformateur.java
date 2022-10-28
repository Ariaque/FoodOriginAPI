package com.istic.foodorigin.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "foodOrigin_groupeTransformateur")

public class GroupeTransformateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Add more attributes

    @OneToMany
    private List<Transformateur> transformateurs;
}
