package com.istic.foodorigin.controller;

import com.istic.foodorigin.dto.AddGroupeTransformateurDto;
import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.models.Label;
import com.istic.foodorigin.service.GroupeTransformateurService;
import com.istic.foodorigin.service.LabelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupeTransformateur>> findAll() {
        List<GroupeTransformateur> list = StreamSupport.stream(
                        groupeTransformateurService.getAllGroupeTransformateurs().spliterator(),
                        false)
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<GroupeTransformateur>> findById(@PathVariable Long id) {
        Optional<GroupeTransformateur> groupeTransformateur = groupeTransformateurService.getGroupeTransformateurById(id);
        if (!groupeTransformateur.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(groupeTransformateur, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/transformateur/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<GroupeTransformateur>> findByTransformateurId(@PathVariable Long id) {
        Optional<GroupeTransformateur> set = groupeTransformateurService.findByTransformateurId(id);
        if (!set.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(set, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/label/{label}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Set<GroupeTransformateur>>> findBylabel(@PathVariable String label) {
        Optional<Set<GroupeTransformateur>> set = groupeTransformateurService.findByLabel(label);
        if (!set.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(set, HttpStatus.OK);
        }
    }

}
