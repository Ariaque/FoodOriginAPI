package com.istic.foodorigin.controller;

import com.istic.foodorigin.domain.InfosTransformateur;
import com.istic.foodorigin.service.InfosTransformateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InfosTransformateurController {

    @Autowired
    private InfosTransformateurService infosTransService;

    @GetMapping(value = "/infosTransformateur/{id}", produces = "application/json")
    public InfosTransformateur getTransformateurById (@PathVariable Long id){
        InfosTransformateur infos = infosTransService.getTransformateurById(id);
        return infos;
    }

    @PostMapping(value = "/infosTransformateur", consumes = "application/json", produces = "application/json")
    public InfosTransformateur saveTransformateur_FR (@RequestBody InfosTransformateur infosTransformateur) {
        InfosTransformateur infosTrans = infosTransService.saveTransformateur_FR(infosTransformateur);
        return infosTrans;
    }
}
