package com.istic.foodorigin.service;

import com.istic.foodorigin.domain.Transformateur;
import com.istic.foodorigin.repository.TransformateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransformateurService {

    @Autowired
    private TransformateurRepository transformateurRepository;

    public Iterable <Transformateur> getAllTransformateur () {
        return transformateurRepository.findAll();
    }

    public Transformateur getTransformateur (Integer id) {
        Transformateur ret = null;
        Optional <Transformateur> transformateur = transformateurRepository.findById(id);
        if (transformateur.isPresent()) {
            ret = transformateur.get();
        }
        return ret;
    }
}
