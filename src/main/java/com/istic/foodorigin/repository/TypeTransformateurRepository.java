package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.TypeTransformateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * End point to request the database's table associated to {@link TypeTransformateur} entity.
 */
@Repository
public interface TypeTransformateurRepository extends CrudRepository<TypeTransformateur, Long> {
    TypeTransformateur findByLibelle(String libelle);
}
