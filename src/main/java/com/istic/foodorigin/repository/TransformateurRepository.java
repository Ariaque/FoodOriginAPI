package com.istic.foodorigin.repository;

import com.istic.foodorigin.domain.Transformateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformateurRepository extends CrudRepository <Transformateur, Long> {
}
