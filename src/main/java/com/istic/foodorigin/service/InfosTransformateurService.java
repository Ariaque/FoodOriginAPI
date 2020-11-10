package com.istic.foodorigin.service;

import com.istic.foodorigin.domain.InfosTransformateur;
import com.istic.foodorigin.domain.Transformateur;
import com.istic.foodorigin.models.InfosTransformateur;
import com.istic.foodorigin.repository.InfosTransformateurRepository;
import com.istic.foodorigin.repository.TransformateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InfosTransformateurService {

    @Autowired
    private InfosTransformateurRepository infosRepository;

    @Autowired
    private TransformateurRepository transformateurRepository;

    public InfosTransformateur getInfosById (Long id) {
        InfosTransformateur ret = null;
        Optional <InfosTransformateur> infos = infosRepository.findById(id);
        if (infos.isPresent()) {
            ret = infos.get();
        }
        return ret;
    }

    public void saveInfos (InfosTransformateur infos) {
        infosRepository.save(infos);
    }

    public InfosTransformateur getInfosByTransformateur (Long id) {
        InfosTransformateur ret = null;
        Transformateur transformateur = transformateurRepository.findById(id).get();
        ret = infosRepository.findByTransformateur(transformateur);
        return ret;
    }
}
