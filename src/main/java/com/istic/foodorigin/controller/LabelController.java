package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.Label;
import com.istic.foodorigin.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping(path = "/all", produces = "application/json")
    public Set<Label> getAllLabel () {
        Iterable<Label> itLab = labelService.getAllLabels();
        List <Label> labels = StreamSupport.stream(itLab.spliterator(), false).collect(Collectors.toList());
        Set<Label> ret = new HashSet<>(labels);
        return ret;
    }

    @GetMapping (path = "/{id}", produces = "application/json")
    public Label getLabelById(@PathVariable Long id) {
        Label label = labelService.getLabelById(id);
        return label;
    }
}
