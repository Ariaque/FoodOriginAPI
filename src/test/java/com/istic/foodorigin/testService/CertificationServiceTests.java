package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.Certification;
import com.istic.foodorigin.service.CertificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CertificationServiceTests {

    @Autowired
    private CertificationService certificationService;

    @Test
    public void testGetCertificationByIdExist() {
        Long id = Integer.toUnsignedLong(3);
        Certification found = certificationService.getCertificationById(id);
        assertThat(found.getId()).isEqualTo(id);
        assertThat(found.getLibelle()).isEqualTo("Certification ISO 18001");
    }

    @Test
    public void testGetCertificationByIdNotExist() {
        Long id = Integer.toUnsignedLong(15);
        Certification found = certificationService.getCertificationById(id);
        assertThat(found).isNull();
    }

    @Test
    public void testGetCertificationByIdNull() {
        Certification found = certificationService.getCertificationById(null);
        assertThat(found).isNull();
    }

    @Test
    public void testGetAllCertifications () {
        Iterable<Certification> itCertif = certificationService.getAllCertifications();
        List<Certification> found = StreamSupport.stream(itCertif.spliterator(), false).collect(Collectors.toList());
        assertThat(found.size()).isEqualTo(7);
    }
}
