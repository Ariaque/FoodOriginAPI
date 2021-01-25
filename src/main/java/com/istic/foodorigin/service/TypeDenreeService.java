package com.istic.foodorigin.service;

import com.istic.foodorigin.models.TypeDenree;
import com.istic.foodorigin.repository.TypeDenreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Class which calls {@link TypeDenreeRepository} and processes information returned.
 */
@Service
public class TypeDenreeService {

    @Autowired
    private TypeDenreeRepository typeDenreeRepository;

    public List<TypeDenree> getAll() {
        Iterable<TypeDenree> it = typeDenreeRepository.findAll();
        List<TypeDenree> all = StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList());
        return all;
    }

    public Set<String> getAllNom() {
        List<String> liste = new ArrayList<>();
        Iterable<TypeDenree> it = typeDenreeRepository.findAll();
        List<TypeDenree> all = StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList());
        for (int i = 0; i < all.size(); i++) {
            liste.add(all.get(i).getNom());
        }
        Set<String> ret = new HashSet<>(liste);
        return ret;
    }

    public Set<String> getEspeceByNom(String nom) {
        List<String> liste = new ArrayList<>();
        if (nom != null) {
            List<TypeDenree> types = typeDenreeRepository.findByNom(nom);
            for (int i = 0; i < types.size(); i++) {
                liste.add(types.get(i).getEspece());
            }
        }
        Set<String> ret = new HashSet<>(liste);
        return ret;
    }

    public Set<String> getAnimalByEspece(String espece) {
        List<String> liste = new ArrayList<>();
        if (espece != null) {
            List<TypeDenree> types = typeDenreeRepository.findByEspece(espece);
            for (int i = 0; i < types.size(); i++) {
                liste.add(types.get(i).getAnimal());
            }
        }
        Set<String> ret = new HashSet<>(liste);
        return ret;
    }


}
