package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.InfosTransformateur;
import com.istic.foodorigin.models.Transformateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * End point to request the database's table associated to {@link InfosTransformateur} entity.
 */
@Repository
public interface InfosTransformateurRepository extends CrudRepository<InfosTransformateur, Long> {
    InfosTransformateur findByTransformateur(Transformateur transformateur);
}
