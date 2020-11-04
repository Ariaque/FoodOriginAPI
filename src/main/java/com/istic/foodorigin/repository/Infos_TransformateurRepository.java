package com.istic.foodorigin.repository;

import com.istic.foodorigin.model.Infos_Transformateur;
import org.springframework.data.repository.CrudRepository;

public interface Infos_TransformateurRepository extends CrudRepository <Infos_Transformateur, Long> {
    Infos_Transformateur getInfosTransformateurById(Long id);
    Infos_Transformateur saveInfosTransformateur (Infos_Transformateur infosTransformateur);
}
