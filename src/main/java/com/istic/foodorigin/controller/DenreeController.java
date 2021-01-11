package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.DenreeAnimale;
import com.istic.foodorigin.service.DenreeAnimaleService;
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

@RestController
@RequestMapping ("/denree")
public class DenreeController {

    @Autowired
    private DenreeAnimaleService denreeAnimaleService;

    @GetMapping(path = "/all", produces = "application/json")
    public Set<DenreeAnimale> getAll () {
        Iterable<DenreeAnimale> itDenree = denreeAnimaleService.getAllDenrees();
        List<DenreeAnimale> denrees = StreamSupport.stream(itDenree.spliterator(), false).collect(Collectors.toList());
        Set<DenreeAnimale> ret = new HashSet<>(denrees);
        return ret;
    }

    @GetMapping (path = "/{id}", produces = "application/json")
    public DenreeAnimale getDenreeById(@PathVariable Long id) {
        DenreeAnimale denree = denreeAnimaleService.getDenreeById(id);
        return denree;
    }
}
