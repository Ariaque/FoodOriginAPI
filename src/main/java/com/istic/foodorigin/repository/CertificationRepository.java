package com.istic.foodorigin.repository;

import com.istic.foodorigin.model.Certification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CertificationRepository extends CrudRepository<Certification, Long> {
    Certification getCertificationById(Long id);
    List<Certification> getAllCertifications ();
}
