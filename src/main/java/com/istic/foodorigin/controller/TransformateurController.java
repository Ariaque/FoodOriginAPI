package com.istic.foodorigin.controller;

import com.istic.foodorigin.domain.Transformateur;
import com.istic.foodorigin.service.TransformateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class TransformateurController {

    @Autowired
    private TransformateurService transformateurService;

    @GetMapping (path = "/transformateurs", produces = "application/json")
    public List<Transformateur> getAll () {
        Iterable <Transformateur> listTrans = transformateurService.getAllTransformateur();
        List <Transformateur> transformateurs = StreamSupport.stream(listTrans.spliterator(), false).collect(Collectors.toList());
        return transformateurs;
    }

    @GetMapping (path = "/transformateur/{id}", produces = "application/json")
    public Transformateur getTransformateurById (@PathVariable Integer id) {
        return transformateurService.getTransformateur(id);
    }
}
