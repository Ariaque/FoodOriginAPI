package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.TypeDenree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * End point to request the database's table associated to {@link TypeDenree} entity.
 */
@Repository
public interface TypeDenreeRepository extends CrudRepository<TypeDenree, Long> {
    List<TypeDenree> findByNom(String nom);

    List<TypeDenree> findByEspece(String espece);
}
