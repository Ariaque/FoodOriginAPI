package com.istic.foodorigin.service;

import com.istic.foodorigin.model.Certification;
import com.istic.foodorigin.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificationService {

    @Autowired
    private CertificationRepository repository;

    public List<Certification> getAllCertifications () {
        List<Certification> certifications = repository.getAllCertifications();
        return certifications;
    }

    public Certification getCertificationById(Long id) {
        Certification certif = repository.getCertificationById(id);
        return certif;
    }

}
