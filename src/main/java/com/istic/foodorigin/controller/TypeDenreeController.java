package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.TypeDenree;
import com.istic.foodorigin.service.TypeDenreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping ("/typeDenree")
public class TypeDenreeController {

    @Autowired
    private TypeDenreeService typeDenreeService;

    @GetMapping(path = "/all", produces = "application/json")
    public Set<TypeDenree> getAllTypeDenree () {
        List<TypeDenree> typesD = typeDenreeService.getAll();
        Set<TypeDenree> ret = new HashSet<>(typesD);
        return ret;
    }

    @GetMapping(path = "/nom", produces = "application/json")
    public Set<String> getAllNomTypeDenree () {
        List<String> typesD = typeDenreeService.getAllNom();
        Set<String> ret = new HashSet<>(typesD);
        return ret;
    }

    @GetMapping(path = "/espece", produces = "application/json")
    public Set<String> getEspeceByNom(@RequestParam("nom") String nom) {
        List<String> typesD = typeDenreeService.getEspeceByNom(nom);
        Set<String> ret = new HashSet<>(typesD);
        return ret;
    }

    @GetMapping(path = "/animal", produces = "application/json")
    public Set<String> getAnimalByEspece (@RequestParam("espece") String espece) {
        List<String> typesD = typeDenreeService.getAnimalByEspece(espece);
        Set<String> ret = new HashSet<>(typesD);
        return ret;
    }
}
