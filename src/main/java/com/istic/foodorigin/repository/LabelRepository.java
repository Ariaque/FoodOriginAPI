package com.istic.foodorigin.repository;

import com.istic.foodorigin.domain.Label;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends CrudRepository <Label, Integer> {
}
