package com.istic.foodorigin.controller;

import com.istic.foodorigin.dto.AddGroupeTransformateurDto;
import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.models.Label;
import com.istic.foodorigin.service.GroupeTransformateurService;
import com.istic.foodorigin.service.LabelService;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping(path = "/groupTransformateur")
public class GroupeTransformateurController {

    private final GroupeTransformateurService groupeTransformateurService;
    private final LabelService labelService;


    public GroupeTransformateurController(GroupeTransformateurService groupeTransformateurService, LabelService labelService) {
        this.groupeTransformateurService = groupeTransformateurService;
        this.labelService = labelService;
    }

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public GroupeTransformateur saveGroupe(@RequestBody AddGroupeTransformateurDto dto) {
        GroupeTransformateur groupeTransformateur = new GroupeTransformateur();
        groupeTransformateur.setDescription(dto.getDescription());
        Set<Label> labels = new HashSet<>();
        for (Long id : dto.getLabelIds()) {
            Label l = labelService.getLabelById(id);
            if (l != null) {
                labels.add(l);
            }
        }
        labels.forEach(groupeTransformateur::addLabel);

        return groupeTransformateurService.saveGroupe(groupeTransformateur);
    }

    @GetMapping(value = "/all", consumes = "application/json", produces = "application/json")
    public List<GroupeTransformateur> findAll() {
        return StreamSupport.stream(
                        groupeTransformateurService.getAllGroupeTransformateurs().spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public GroupeTransformateur findById(@PathVariable Long id) {
        return groupeTransformateurService.getGroupeTransformateurById(id);
    }

    @GetMapping(value = "/transformateur/{id}", consumes = "application/json", produces = "application/json")
    public GroupeTransformateur findByTransformateurId(@PathVariable Long id) {
        return groupeTransformateurService.findByTransformateurId(id);
    }

    @GetMapping(value = "/label/{label}", consumes = "application/json", produces = "application/json")
    public Optional<Set<GroupeTransformateur>> findBylabel(@PathVariable String label) {
        return groupeTransformateurService.findByLabel(label);
    }

}
