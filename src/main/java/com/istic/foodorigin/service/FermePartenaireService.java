package com.istic.foodorigin.service;

import com.istic.foodorigin.models.FermePartenaire;
import com.istic.foodorigin.repository.FermePartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FermePartenaireService {
    @Autowired
    private FermePartenaireRepository fermePartenaireRepository;

    public Iterable<FermePartenaire> getAllFermes () {
        Iterable<FermePartenaire> fermes = fermePartenaireRepository.findAll();
        return fermes;
    }

    public FermePartenaire getFermeById(Long id) {
        FermePartenaire ret = null;
        if (id != null) {
            Optional<FermePartenaire> fermePartenaire = fermePartenaireRepository.findById(id);
            if (fermePartenaire.isPresent()) {
                ret = fermePartenaire.get();
            }
        }
        return ret;
    }
}
