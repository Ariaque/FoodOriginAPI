package com.istic.foodorigin.service;

import com.istic.foodorigin.models.DenreeAnimale;
import com.istic.foodorigin.repository.DenreeAnimaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DenreeAnimaleService {

    @Autowired
    private DenreeAnimaleRepository denreeAnimaleRepository;

    public Iterable<DenreeAnimale> getAllDenrees () {
        Iterable<DenreeAnimale> denrees = denreeAnimaleRepository.findAll();
        return denrees;
    }

    public DenreeAnimale getDenreeById(Long id) {
        DenreeAnimale ret = null;
        Optional<DenreeAnimale> denree = denreeAnimaleRepository.findById(id);
        if (denree.isPresent()) {
            ret = denree.get();
        }
        return ret;
    }
}
