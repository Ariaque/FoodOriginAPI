package com.istic.foodorigin.service;

import com.istic.foodorigin.model.Label;

import java.util.List;

public interface LabelService {
    Label getLabelById(Long id);
    List<Label> getAllLabels ();
}
