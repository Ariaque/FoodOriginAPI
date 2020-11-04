package com.istic.foodorigin.service;

import com.istic.foodorigin.model.Label;
import com.istic.foodorigin.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {

    @Autowired
    private LabelRepository repository;

    public List<Label> getAllLabels () {
        List<Label> labels = repository.getAllLabels();
        return labels;
    }

    public Label getLabelById(Long id) {
        Label label = repository.getLabelById(id);
        return label;
    }

}
