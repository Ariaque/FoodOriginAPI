package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.service.TransformateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transformateur")
public class TransformateurController {

    @Autowired
    private TransformateurService transformateurService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public Transformateur getTransformateurById(@PathVariable Long id) {
        return transformateurService.getTransformateur(id);
    }

    @GetMapping(path = "/siret/{siret}", produces = "application/json")
    public Transformateur getTransformateurBySiret(@PathVariable String siret) {
        return transformateurService.getTransformateurBySiret(siret);
    }

    @GetMapping(produces = "application/json")
    public Transformateur getTransformateurByEstampille(@RequestParam(value = "estampille") String estampille) {
        return transformateurService.getTransformateurByEstampille(estampille);
    }
}
