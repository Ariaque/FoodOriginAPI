package com.istic.foodorigin.service;

import com.istic.foodorigin.models.TypeDenree;
import com.istic.foodorigin.repository.TypeDenreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TypeDenreeService {

    @Autowired
    private TypeDenreeRepository typeDenreeRepository;

    public List<TypeDenree> getAll () {
        Iterable<TypeDenree> it = typeDenreeRepository.findAll();
        List <TypeDenree> all = StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList());
        return all;
    }

    public List<String> getAllNom () {
        List<String> ret = new ArrayList<>();
        Iterable<TypeDenree> it = typeDenreeRepository.findAll();
        List <TypeDenree> all = StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList());
        for (int i =0; i < all.size(); i++) {
            ret.add(all.get(i).getNom());
        }
        return ret;
    }

    public List<String> getEspeceByNom (String nom) {
        List<String> ret = new ArrayList<>();
        if (nom != null) {
            List <TypeDenree> types = typeDenreeRepository.findByNom(nom);
            for (int i =0; i < types.size(); i++) {
                ret.add(types.get(i).getEspece());
            }
        }
        return ret;
    }

    public List<String> getAnimalByEspece (String espece) {
        List<String> ret = new ArrayList<>();
        if (espece != null) {
            List <TypeDenree> types = typeDenreeRepository.findByEspece(espece);
            for (int i =0; i < types.size(); i++) {
                ret.add(types.get(i).getAnimal());
            }
        }
        return ret;
    }


}
