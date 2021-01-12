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

    public Transformateur getTransformateur(Long id) {
        Transformateur ret = null;
        Optional<Transformateur> transformateur = transformateurRepository.findById(id);
        if (transformateur.isPresent()) {
            ret = transformateur.get();
        }
        return ret;
    }

    public Transformateur getTransformateurBySiret(String siret) {
        Transformateur ret = null;
        List<Transformateur> transformateurs = transformateurRepository.findBySiret(siret);
        if(transformateurs.size() > 0){
            ret = transformateurs.get(0);
        }
        return ret;
    }

    public Transformateur getTransformateurByEstampille(String estampille) {
        List<Transformateur> transformateur = transformateurRepository.findByNumAgrement(estampille);
        // sometimes, several lines for one stamp
        return transformateur.get(0);
    }
}
