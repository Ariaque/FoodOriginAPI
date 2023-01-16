package com.istic.foodorigin.controller;

import com.istic.foodorigin.dto.OneToOneDto;
import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.service.GroupeTransformateurService;
import com.istic.foodorigin.service.TransformateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Point of contact allowing client applications
 * to retrieve information about {@link Transformateur}.
 */
@RestController
@RequestMapping("/transformateur")
public class TransformateurController {

    @Autowired
    private TransformateurService transformateurService;
    @Autowired
    private GroupeTransformateurService groupeTransformateurService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public Transformateur getTransformateurById(@PathVariable Long id) {
        return transformateurService.getTransformateurById(id);
    }

    @GetMapping(path = "/siret/{siret}", produces = "application/json")
    public Transformateur getTransformateurBySiret(@PathVariable String siret) {
        return transformateurService.getTransformateurBySiret(siret);
    }

    @GetMapping(path = "/groupid/{id}", consumes = "application/json")
    public List<Transformateur> getTransformateurByGroupId(@PathVariable Long id) {
        return transformateurService.getTransformateurByGroupId(id);
    }

    @GetMapping(produces = "application/json")
    public Transformateur getTransformateurByEstampille(@RequestParam(value = "estampille") String estampille) {
        return transformateurService.getTransformateurByEstampille(estampille);
    }

    @PutMapping(path = "/addGroup", consumes = "application/json", produces = "application/json")
    public Transformateur addGroupe(@RequestBody OneToOneDto dto) {
        Optional<GroupeTransformateur> groupeTransformateur = groupeTransformateurService.getGroupeTransformateurById(dto.getForeignId());
        Transformateur transformateur = transformateurService.getTransformateurById(dto.getMainId());

        if (transformateur == null) {
            throw new IllegalArgumentException("No transformateur with the provided id");
        }
        if (!groupeTransformateur.isPresent()) {
            throw new IllegalArgumentException("No Transformateur group with the provided id");
        }
        transformateur.setGroupeTransformateur(groupeTransformateur.get());
        transformateurService.update(transformateur);

        return transformateur;
    }

}
