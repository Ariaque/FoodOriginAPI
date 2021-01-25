package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.Certification;
import com.istic.foodorigin.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Point of contact allowing client applications
 * to retrieve information about {@link Certification} from database.
 */
@RestController
@RequestMapping(path = "/certification")
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @GetMapping(path = "/all", produces = "application/json")
    public List<Certification> getAll() {
        Iterable<Certification> itCertif = certificationService.getAllCertifications();
        List<Certification> ret = StreamSupport.stream(itCertif.spliterator(), false).collect(Collectors.toList());
        return ret;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Certification getCertifById(@PathVariable Long id) {
        return certificationService.getCertificationById(id);
    }
}
