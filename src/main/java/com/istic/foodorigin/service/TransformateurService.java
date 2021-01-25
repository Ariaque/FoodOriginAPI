package com.istic.foodorigin.service;

import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.repository.TransformateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class which calls {@link TransformateurRepository} and processes information returned.
 */
@Service
public class TransformateurService {

    @Autowired
    private TransformateurRepository transformateurRepository;

    public Transformateur getTransformateurById(Long id) {
        Transformateur ret = null;
        if (id != null) {
            Optional<Transformateur> transformateur = transformateurRepository.findById(id);
            if (transformateur.isPresent()) {
                ret = transformateur.get();
            }
        }
        return ret;
    }

    public Transformateur getTransformateurBySiret(String siret) {
        Transformateur ret = null;
        if (siret != null && siret.length() == 14) {
            List<Transformateur> transformateurs = transformateurRepository.findBySiret(siret);
            if (transformateurs.size() > 0) {
                ret = transformateurs.get(0);
            }
        }
        return ret;
    }

    public Transformateur getTransformateurByEstampille(String estampille) {
        Transformateur transformateur = null;
        if (estampille != null) {
            List<Transformateur> transformateurs = transformateurRepository.findByNumAgrement(estampille);
            // sometimes, several lines for one stamp
            if (transformateurs.size() != 0) {
                transformateur = transformateurs.get(0);
            }
        }
        return transformateur;
    }
}
