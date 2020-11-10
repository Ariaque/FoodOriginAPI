package com.istic.foodorigin.repository;

import com.istic.foodorigin.domain.TypeTransformateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTransformateurRepository extends CrudRepository <TypeTransformateur, Long> {
}
