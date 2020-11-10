package com.istic.foodorigin.controller;

import com.istic.foodorigin.domain.Label;
import com.istic.foodorigin.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping(path = "/all", produces = "application/json")
    public List<Label> getAllLabel () {
        Iterable<Label> itLab = labelService.getAllLabels();
        List <Label> labels = StreamSupport.stream(itLab.spliterator(), false).collect(Collectors.toList());
        return labels;
    }

    @GetMapping (path = "/{id}", produces = "application/json")
    public Label getLabelById(@PathVariable Integer id) {
        Label label = labelService.getLabelById(id);
        return label;
    }
}
