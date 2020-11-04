package com.istic.foodorigin.repository;

import com.istic.foodorigin.model.Transformateur_FR;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Transformateur_FRRepository extends CrudRepository <Transformateur_FR, Long> {
    Transformateur_FR getTransformateurById(Long id);
    List<Transformateur_FR> getAllTransformateurs ();
    Transformateur_FR saveTransformateur (Transformateur_FR transformateur);
}
