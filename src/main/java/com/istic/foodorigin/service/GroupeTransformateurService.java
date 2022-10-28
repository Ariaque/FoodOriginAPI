package com.istic.foodorigin.service;

import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.repository.GroupeTransformateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupeTransformateurService {
    
    private final GroupeTransformateurRepository groupeTransformateurRepository;

    public GroupeTransformateurService(GroupeTransformateurRepository groupeTransformateurRepository) {
        this.groupeTransformateurRepository = groupeTransformateurRepository;
    }

    public Iterable<GroupeTransformateur> getAllGroupeTransformateurs() {
        return groupeTransformateurRepository.findAll();
    }

    public GroupeTransformateur findByTransformateurId(Long id){
        GroupeTransformateur ret = null;
        if (id != null) {
            Optional<GroupeTransformateur> groupeTransformateur = groupeTransformateurRepository.findByTransformateurs_Id(id);
            if (groupeTransformateur.isPresent()) {
                ret = groupeTransformateur.get();
            }
        }
        return ret;
    }

    public GroupeTransformateur getGroupeTransformateurById(Long id) {
        GroupeTransformateur ret = null;
        if (id != null) {
            Optional<GroupeTransformateur> groupeTransformateur = groupeTransformateurRepository.findById(id);
            if (groupeTransformateur.isPresent()) {
                ret = groupeTransformateur.get();
            }
        }
        return ret;
    }
}
