package com.istic.foodorigin.service;

import com.istic.foodorigin.models.InfosTransformateur;
import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.repository.InfosTransformateurRepository;
import com.istic.foodorigin.repository.TransformateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class which calls {@link InfosTransformateurRepository} and processes information returned.
 */
@Service
public class InfosTransformateurService {

    @Autowired
    private InfosTransformateurRepository infosRepository;

    @Autowired
    private TransformateurRepository transformateurRepository;

    public InfosTransformateur getInfosById(Long id) {
        InfosTransformateur ret = null;
        if (id != null) {
            Optional<InfosTransformateur> infos = infosRepository.findById(id);
            if (infos.isPresent()) {
                ret = infos.get();
            }
        }
        return ret;
    }

    public InfosTransformateur saveInfos(InfosTransformateur infos) {
        InfosTransformateur infosT = null;
        if (infos != null) {
            infosT = infosRepository.save(infos);
        }
        return infosT;
    }

    public InfosTransformateur getInfosByTransformateur(Long id) {
        InfosTransformateur ret = new InfosTransformateur();
        if (id != null) {
            Optional<Transformateur> transformateur = transformateurRepository.findById(id);
            if (transformateur.isPresent()) {
                ret = infosRepository.findByTransformateur(transformateur.get());
            }
        }
        return ret;
    }
}
