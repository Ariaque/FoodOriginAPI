package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.DenreeAnimale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * End point to request the database's table associated to {@link DenreeAnimale} entity.
 */
@Repository
public interface DenreeAnimaleRepository extends CrudRepository<DenreeAnimale, Long> {

}
