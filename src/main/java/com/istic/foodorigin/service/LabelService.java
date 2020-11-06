package com.istic.foodorigin.service;

import com.istic.foodorigin.domain.Label;
import com.istic.foodorigin.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LabelService {

    @Autowired
    private LabelRepository labelRepository;

    public Iterable<Label> getAllLabels () {
        Iterable<Label> labels = labelRepository.findAll();
        return labels;
    }

    public Label getLabelById(Long id) {
        Label ret = null;
        Optional<Label> label = labelRepository.findById(id);
        if (label.isPresent()) {
            ret = label.get();
        }
        return ret;
    }

    public void saveLabel (Label label) {
        labelRepository.save(label);
    }

}
