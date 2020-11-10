package com.istic.foodorigin.service;

import com.istic.foodorigin.domain.Certification;
import com.istic.foodorigin.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificationService {

    @Autowired
    private CertificationRepository certificationRepository;

    public Iterable<Certification> getAllCertifications () {
        Iterable<Certification> certifications = certificationRepository.findAll();
        return certifications;
    }

    public Certification getCertificationById (Long id) {
        Certification ret = null;
        Optional<Certification> certification = certificationRepository.findById(id);
        if (certification.isPresent()) {
            ret = certification.get();
        }
        return ret;
    }

}
