package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.Label;
import com.istic.foodorigin.service.LabelService;
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
 * to retrieve information about {@link Label} from database.
 */
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping(path = "/all", produces = "application/json")
    public Set<Label> getAllLabels() {
        Iterable<Label> itLab = labelService.getAllLabels();
        List<Label> labels = StreamSupport.stream(itLab.spliterator(), false).collect(Collectors.toList());
        Set<Label> ret = new HashSet<>(labels);
        return ret;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Label getLabelById(@PathVariable Long id) {
        Label label = labelService.getLabelById(id);
        return label;
    }
}
