package com.istic.foodorigin.testController;

import com.istic.foodorigin.models.Certification;
import com.istic.foodorigin.repository.CertificationRepository;
import com.istic.foodorigin.service.CertificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CertificationControllerTests {

    @MockBean
    private CertificationService certificationService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CertificationRepository certificationRepository;

    @Test
    public void testGetAll () throws Exception {
        Iterable<Certification> itCertif = certificationRepository.findAll();
        List<Certification> certifs = StreamSupport.stream(itCertif.spliterator(), false).collect(Collectors.toList());

        given (certificationService.getAllCertifications()).willReturn(certifs);
        mockMvc.perform(get("/certification/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(certifs.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void testGetCertifByIdExists () throws Exception {
        Long id = Integer.toUnsignedLong(3);
        Certification c3 = certificationRepository.findById(id).get();

        given (certificationService.getCertificationById(id)).willReturn(c3);
        mockMvc.perform(get("/certification/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect (MockMvcResultMatchers.jsonPath("$.libelle").value(c3.getLibelle()));

    }

    @Test
    public void testGetCertifByIdNotExists () throws Exception {
        Long id = Integer.toUnsignedLong(30);

        given (certificationService.getAllCertifications()).willReturn(null);
        mockMvc.perform(get("/certification/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }
}
