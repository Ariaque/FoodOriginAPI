package com.istic.foodorigin.controller;

import com.istic.foodorigin.domain.Certification;
import com.istic.foodorigin.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @GetMapping (path = "/certifications", produces = "application/json")
    public List<Certification> getAll () {
        Iterable <Certification> itCertif = certificationService.getAllCertifications();
        List <Certification> ret = StreamSupport.stream(itCertif.spliterator(), false).collect(Collectors.toList());
        return ret;
    }

    @GetMapping (path = "/certification/{id}", produces = "application/json")
    public Certification getCertifById (@PathVariable Long id) {
        return certificationService.getCertificationById(id);
    }

    @PostMapping (path = "/certification", consumes = "application/json")
    public void postCertification (@RequestBody Certification certification) {
        certificationService.saveCertification(certification);
    }
}
