package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.Label;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends CrudRepository <Label, Long> {
}
