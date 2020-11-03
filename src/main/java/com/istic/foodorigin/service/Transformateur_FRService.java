package com.istic.foodorigin.service;

import com.istic.foodorigin.model.Transformateur_FR;
import java.util.List;

public interface Transformateur_FRService {
    Transformateur_FR getTransformateurById(Long id);
    List<Transformateur_FR> getAllTransformateurs ();
    Transformateur_FR saveTransformateur (Transformateur_FR transformateur);
}
