package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.TypeTransformateur;
import com.istic.foodorigin.service.TypeTransformateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Point of contact allowing client applications
 * to retrieve information about the type of transformator {@link TypeTransformateur}.
 */
@RestController
@RequestMapping("/typeTransformateur")
public class TypeTransformateurController {

    @Autowired
    private TypeTransformateurService typeTransformateurService;

    @GetMapping (path = "/all", produces = "application/json")
    public List<TypeTransformateur> getAll() {
        Iterable <TypeTransformateur> itType = typeTransformateurService.getAllType();
        List<TypeTransformateur> typesTrans = StreamSupport.stream(itType.spliterator(), false).collect(Collectors.toList());
        return typesTrans;
    }

    @GetMapping (path = "/{id}", produces = "application/json")
    public TypeTransformateur getTypeTransformateurById (@PathVariable Long id) {
        return typeTransformateurService.getTypeById(id);
    }

}
