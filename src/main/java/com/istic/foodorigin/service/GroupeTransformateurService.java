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

    public Optional<GroupeTransformateur> findByTransformateurId(Long id) {
        return (id == null) ? Optional.empty() : groupeTransformateurRepository.findByTransformateurs_Id(id);
    }

    public Optional<Set<GroupeTransformateur>> findByLabel(String label) {
        return (label == null || label.isEmpty()) ? Optional.empty() : groupeTransformateurRepository.findByLabels(label.toLowerCase());
    }

    public Optional<GroupeTransformateur> getGroupeTransformateurById(Long id) {
        return (id == null) ? Optional.empty() : groupeTransformateurRepository.findById(id);
    }
}
