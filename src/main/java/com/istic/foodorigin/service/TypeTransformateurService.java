package com.istic.foodorigin.service;

import com.istic.foodorigin.models.TypeTransformateur;
import com.istic.foodorigin.repository.TypeTransformateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeTransformateurService {

    @Autowired
    private TypeTransformateurRepository typeTransformateurRepository;

    public Iterable<TypeTransformateur> getAllType () {
        return typeTransformateurRepository.findAll();
    }

    public TypeTransformateur getTypeById (Long id) {
        TypeTransformateur ret = null;
        Optional <TypeTransformateur> type = typeTransformateurRepository.findById(id);
        if (type.isPresent()) {
            ret = type.get();
        }
        return ret;
    }
}
