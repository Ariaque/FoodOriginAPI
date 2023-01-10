package com.istic.foodorigin.service;

import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.repository.GroupeTransformateurRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GroupeTransformateurService {

    private final GroupeTransformateurRepository groupeTransformateurRepository;

    public GroupeTransformateurService(GroupeTransformateurRepository groupeTransformateurRepository) {
        this.groupeTransformateurRepository = groupeTransformateurRepository;
    }

    public Iterable<GroupeTransformateur> getAllGroupeTransformateurs() {
        return groupeTransformateurRepository.findAll();
    }

    public GroupeTransformateur saveGroupe(GroupeTransformateur groupeTransformateur) {
        GroupeTransformateur retGroupe = null;
        if (groupeTransformateur != null) {
            retGroupe = groupeTransformateurRepository.save(groupeTransformateur);
        }
        return retGroupe;
    }

    public GroupeTransformateur findByTransformateurId(Long id) {
        GroupeTransformateur ret = null;
        if (id != null) {
            Optional<GroupeTransformateur> groupeTransformateur = groupeTransformateurRepository.findByTransformateurs_Id(id);
            if (groupeTransformateur.isPresent()) {
                ret = groupeTransformateur.get();
            }
        }
        return ret;
    }

    public Optional<Set<GroupeTransformateur>> findByLabel(String label) {
        return (label == null || label.isEmpty()) ? Optional.empty() : groupeTransformateurRepository.findByLabels(label);
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
