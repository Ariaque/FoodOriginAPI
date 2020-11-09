package com.istic.foodorigin.controller;

import com.istic.foodorigin.domain.InfosTransformateur;
import com.istic.foodorigin.service.InfosTransformateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfosTransformateurController {

    @Autowired
    private InfosTransformateurService infosService;

    @GetMapping (path = "infoTransformateur/{id}", produces = "application/json")
    public InfosTransformateur getInfosById (Long id) {
        InfosTransformateur infosTransformateur = infosService.getInfosById(id);
        return infosTransformateur;
    }

    @PostMapping (path = "infosTransformateur", consumes = "application/json")
    public void saveInfosTrans (@RequestBody InfosTransformateur infos) {
        infosService.saveInfos(infos);
    }
}
