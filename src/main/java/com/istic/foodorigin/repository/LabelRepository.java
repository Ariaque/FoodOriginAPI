package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.Label;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * End point to request the database's table associated to {@link Label} entity.
 */
@Repository
public interface LabelRepository extends CrudRepository<Label, Long> {
}
