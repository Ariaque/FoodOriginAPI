package com.istic.foodorigin.service;

import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.repository.TransformateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransformateurService {

    @Autowired
    private TransformateurRepository transformateurRepository;

    public Transformateur getTransformateur (Long id) {
        Transformateur ret = null;
        Optional <Transformateur> transformateur = transformateurRepository.findById(id);
        if (transformateur.isPresent()) {
            ret = transformateur.get();
        }
        return ret;
    }

    public Long getIdBySiret (String siret) {
        List <Transformateur> transformateurs = transformateurRepository.findBySiret(siret);
        Long ret = transformateurs.get(0).getId();
        return ret;
    }
}
