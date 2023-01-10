package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.FermePartenaire;
import com.istic.foodorigin.service.FermePartenaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Point of contact allowing client applications
 * to retrieve information about {@link FermePartenaire} from database.
 */
@RestController
@RequestMapping("/ferme")
public class FermePartenaireController {

    @Autowired
    private FermePartenaireService fermePartenaireService;

    @GetMapping(path = "/all", produces = "application/json")
    public Set<FermePartenaire> getAll() {
        Iterable<FermePartenaire> itFerme = fermePartenaireService.getAllFermes();
        List<FermePartenaire> fermes = StreamSupport.stream(itFerme.spliterator(), false).collect(Collectors.toList());
        Set<FermePartenaire> ret = new HashSet<>(fermes);
        return ret;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public FermePartenaire getFermeById(@PathVariable Long id) {
        FermePartenaire ferme = fermePartenaireService.getFermeById(id);
        return ferme;
    }
}
