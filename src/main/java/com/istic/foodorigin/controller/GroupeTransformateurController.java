package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.service.GroupeTransformateurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/groupTransformateur")
public class GroupeTransformateurController {

    private final GroupeTransformateurService groupeTransformateurService;

    public GroupeTransformateurController(GroupeTransformateurService groupeTransformateurService) {
        this.groupeTransformateurService = groupeTransformateurService;
    }

    @GetMapping(value = "/all", consumes = "application/json")
    public List<GroupeTransformateur> findAll(){
        List<GroupeTransformateur> groupeTransformateurs = StreamSupport.stream(
                    groupeTransformateurService.getAllGroupeTransformateurs().spliterator(),
                    false)
                .collect(Collectors.toList());
        return groupeTransformateurs;
    }

    @GetMapping(value = "/{id}", consumes = "application/json")
    public GroupeTransformateur findById(@PathVariable Long id){
        return groupeTransformateurService.getGroupeTransformateurById(id);
    }

    @GetMapping(value = "/transformateur/{id}", consumes = "application/json")
    public GroupeTransformateur findByTransformateurId(@PathVariable Long id){
        return groupeTransformateurService.findByTransformateurId(id);
    }


}
