package com.istic.foodorigin.controller;

import com.istic.foodorigin.domain.TransformateurFR;
import com.istic.foodorigin.service.TransformateurFRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransformateurController {

    @Autowired
    private TransformateurFRService transformateurService;

    @GetMapping(value = "/transformateurs", produces = "application/json")
    public List<TransformateurFR> getAllTransformateurs (){
        List<TransformateurFR> transformateurs = transformateurService.getAllTransformateurs();
        return transformateurs;
    }

    @GetMapping (value = "/transformateur/{id}", produces = "application/json")
    public TransformateurFR getTransformateurById (@PathVariable Long id){
        TransformateurFR transformateur = transformateurService.getTransformateurById(id);
        return transformateur;
    }

    @PostMapping (value = "/transformateur", consumes = "application/json", produces = "application/json")
    public TransformateurFR saveTransformateur (@RequestBody TransformateurFR transformateur) {
        TransformateurFR transformateur_fr = transformateurService.saveTransformateur_FR(transformateur);
        return transformateur_fr;
    }
}
