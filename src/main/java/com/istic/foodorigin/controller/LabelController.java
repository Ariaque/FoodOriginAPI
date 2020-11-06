package com.istic.foodorigin.controller;

import com.istic.foodorigin.domain.Label;
import com.istic.foodorigin.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping(path = "/labels", produces = "application/json")
    public List<Label> getAllLabel () {
        Iterable<Label> itLab = labelService.getAllLabels();
        List <Label> labels = StreamSupport.stream(itLab.spliterator(), false).collect(Collectors.toList());
        return labels;
    }

    @GetMapping (path = "/label/{id}", produces = "application/json")
    public Label getLabelById(@PathVariable Long id) {
        Label label = labelService.getLabelById(id);
        return label;
    }

    @PostMapping (path = "/label", consumes = "application/json")
    public void postLabel (@RequestBody Label label) {
        labelService.saveLabel(label);
    }
}
