package com.istic.foodorigin.service;

import com.istic.foodorigin.model.Certification;
import java.util.List;

public interface CertificationService {
    Certification getCertificationById(Long id);
    List<Certification> getAllCertifications ();
}
