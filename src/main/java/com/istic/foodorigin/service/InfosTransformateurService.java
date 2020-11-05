package com.istic.foodorigin.service;

import com.istic.foodorigin.domain.InfosTransformateur;
import com.istic.foodorigin.repository.InfosTransformateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfosTransformateurService {

    @Autowired
    private InfosTransformateurRepository infosTransRepository;

    public InfosTransformateur getTransformateurById (Long id){
        InfosTransformateur infos = infosTransRepository.getInfosTransformateurById(id);
        return infos;
    }

    public InfosTransformateur saveTransformateur_FR (InfosTransformateur infosTransformateur) {
        InfosTransformateur infosTrans = infosTransRepository.saveInfosTransformateur(infosTransformateur);
        return infosTrans;
    }
}
