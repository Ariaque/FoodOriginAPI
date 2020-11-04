package com.istic.foodorigin.controller;

import com.istic.foodorigin.model.Certification;
import com.istic.foodorigin.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @GetMapping(value = "/certifs", produces = "application/json")
    public List<Certification> getAllCertifications () {
        List<Certification> certifications = certificationService.getAllCertifications();
        return certifications;
    }

    @GetMapping (value = "/certif/{id}", produces = "application/json")
    public Certification getCertifById(@PathVariable Long id) {
        Certification certif = certificationService.getCertificationById(id);
        return certif;
    }
}
