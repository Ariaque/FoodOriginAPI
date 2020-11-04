package com.istic.foodorigin.service;

import com.istic.foodorigin.model.Infos_Transformateur;
import com.istic.foodorigin.repository.Infos_TransformateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Infos_TransformateurService {

    @Autowired
    private Infos_TransformateurRepository infosTransRepository;

    public Infos_Transformateur getTransformateurById (Long id){
        Infos_Transformateur infos = infosTransRepository.getInfosTransformateurById(id);
        return infos;
    }

    public Infos_Transformateur saveTransformateur_FR (Infos_Transformateur infosTransformateur) {
        Infos_Transformateur infosTrans = infosTransRepository.saveInfosTransformateur(infosTransformateur);
        return infosTrans;
    }
}
