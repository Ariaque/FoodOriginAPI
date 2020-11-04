package com.istic.foodorigin.repository;

import com.istic.foodorigin.model.Label;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LabelRepository extends CrudRepository <Label, Long> {
    Label getLabelById(Long id);
    List<Label> getAllLabels ();
}
