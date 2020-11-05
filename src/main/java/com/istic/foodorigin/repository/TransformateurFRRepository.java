package com.istic.foodorigin.repository;

import com.istic.foodorigin.domain.TransformateurFR;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransformateurFRRepository extends CrudRepository <TransformateurFR, Long> {
    TransformateurFR getTransformateurById(Long id);
    List<TransformateurFR> getAllTransformateurs ();
    TransformateurFR saveTransformateur (TransformateurFR transformateur);
}
