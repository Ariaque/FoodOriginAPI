package com.istic.foodorigin.controller;

import com.istic.foodorigin.model.Label;
import com.istic.foodorigin.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping(value = "/labels", produces = "application/json")
    public List<Label> getAllLabel () {
        List<Label> labels = labelService.getAllLabels();
        return labels;
    }

    @GetMapping (value = "/label/{id}", produces = "application/json")
    public Label getLabelById(@PathVariable Long id) {
        Label label = labelService.getLabelById(id);
        return label;
    }
}
