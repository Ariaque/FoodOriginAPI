package com.istic.foodorigin.controller;

import com.istic.foodorigin.model.Infos_Transformateur;
import com.istic.foodorigin.service.Infos_TransformateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InfosTransformateurController {

    @Autowired
    private Infos_TransformateurService infosTransService;

    @GetMapping(value = "/infosTransformateur/{id}", produces = "application/json")
    public Infos_Transformateur getTransformateurById (@PathVariable Long id){
        Infos_Transformateur infos = infosTransService.getTransformateurById(id);
        return infos;
    }

    @PostMapping(value = "/infosTransformateur", consumes = "application/json", produces = "application/json")
    public Infos_Transformateur saveTransformateur_FR (@RequestBody Infos_Transformateur infosTransformateur) {
        Infos_Transformateur infosTrans = infosTransService.saveTransformateur_FR(infosTransformateur);
        return infosTrans;
    }
}
