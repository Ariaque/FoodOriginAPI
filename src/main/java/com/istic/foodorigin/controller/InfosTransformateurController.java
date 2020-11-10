package com.istic.foodorigin.controller;

import com.istic.foodorigin.domain.InfosTransformateur;
import com.istic.foodorigin.service.InfosTransformateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/infoTransformateur")
public class InfosTransformateurController {

    @Autowired
    private InfosTransformateurService infosService;

    @GetMapping (path = "/{id}", produces = "application/json")
    public InfosTransformateur getInfosById (@PathVariable Long id) {
        InfosTransformateur infosTransformateur = infosService.getInfosById(id);
        return infosTransformateur;
    }

    @PostMapping (consumes = "application/json")
    public String saveInfosTrans (@RequestBody InfosTransformateur infos) {
        infosService.saveInfos(infos);
        return "Informations ajoutées";
    }

    @GetMapping (path = "transformateur/{id}", produces = "application/json")
    public InfosTransformateur getInfosByTransformateur (@PathVariable Long id) {
        InfosTransformateur infosTransformateur = infosService.getInfosByTransformateur (id);
        return infosTransformateur;
    }
}
