package com.istic.foodorigin.controller;

import com.istic.foodorigin.model.Transformateur_FR;
import com.istic.foodorigin.service.Transformateur_FRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransformateurController {

    @Autowired
    private Transformateur_FRService transformateurService;

    @GetMapping(value = "/transformateurs", produces = "application/json")
    public List<Transformateur_FR> getAllTransformateurs (){
        List<Transformateur_FR> transformateurs = transformateurService.getAllTransformateurs();
        return transformateurs;
    }

    @GetMapping (value = "/transformateur/{id}", produces = "application/json")
    public Transformateur_FR getTransformateurById (@PathVariable Long id){
        Transformateur_FR transformateur = transformateurService.getTransformateurById(id);
        return transformateur;
    }

    @PostMapping (value = "/transformateur", consumes = "application/json", produces = "application/json")
    public Transformateur_FR saveTransformateur (@RequestBody Transformateur_FR transformateur) {
        Transformateur_FR transformateur_fr = transformateurService.saveTransformateur_FR(transformateur);
        return transformateur_fr;
    }
}
