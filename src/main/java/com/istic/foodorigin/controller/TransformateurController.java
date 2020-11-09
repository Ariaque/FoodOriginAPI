package com.istic.foodorigin.controller;

import com.istic.foodorigin.domain.Transformateur;
import com.istic.foodorigin.service.TransformateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transformateur")
public class TransformateurController {

    @Autowired
    private TransformateurService transformateurService;

    @GetMapping (path = "/transformateur/{id}", produces = "application/json")
    public Transformateur getTransformateurById (@PathVariable Integer id) {
        return transformateurService.getTransformateur(id);
    }
}
