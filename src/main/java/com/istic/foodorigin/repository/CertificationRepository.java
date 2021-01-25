package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.Certification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * End point to request the database's table associated to {@link Certification} entity.
 */
@Repository
public interface CertificationRepository extends CrudRepository<Certification, Long> {
}
