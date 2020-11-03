package com.istic.foodorigin.service;

import com.istic.foodorigin.model.Infos_Transformateur;

import java.util.List;

public interface Infos_TransformateurService {
    Infos_Transformateur getInfosTransformateurById(Long id);
    Infos_Transformateur saveInfosTransformateur (Infos_Transformateur infosTransformateur);
}
