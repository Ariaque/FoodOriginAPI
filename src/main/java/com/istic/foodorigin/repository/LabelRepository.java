package com.istic.foodorigin.repository;

import com.istic.foodorigin.domain.Label;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LabelRepository extends CrudRepository <Label, Long> {
    Label getLabelById(Long id);
    List<Label> getAllLabels ();
}
