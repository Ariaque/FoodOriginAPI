package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.Transformateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransformateurRepository extends CrudRepository <Transformateur, Long> {
    List<Transformateur> findBySiret (String raisonSociale);
}
