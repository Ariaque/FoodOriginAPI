package com.istic.foodorigin.service;

import com.istic.foodorigin.models.InfosTransformateur;
import com.istic.foodorigin.repository.InfosTransformateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InfosTransformateurService {

    @Autowired
    private InfosTransformateurRepository infosRepository;

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
}
