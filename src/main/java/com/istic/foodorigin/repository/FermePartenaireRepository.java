package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.FermePartenaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * End point to request the database's table associated to {@link FermePartenaire} entity.
 */
@Repository
public interface FermePartenaireRepository extends CrudRepository<FermePartenaire, Long> {
}
