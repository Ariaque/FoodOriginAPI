package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.InfosTransformateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfosTransformateurRepository extends CrudRepository<InfosTransformateur, Long> {
}
