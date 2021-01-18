package com.istic.foodorigin.testController;

import com.istic.foodorigin.controller.TransformateurController;
import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.repository.TransformateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransformateurControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TransformateurRepository transformateurRepository;

    @MockBean
    private TransformateurController transformateurController;

    @Test
    public void testGetTansformateurByIdExists () throws Exception {
        Long id = Integer.toUnsignedLong(20);
        Transformateur transformateur = transformateurRepository.findById(id).get();

        given (transformateurController.getTransformateurById(id)).willReturn(transformateur);
        mockMvc.perform(get("/transformateur/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect (MockMvcResultMatchers.jsonPath("$.num_agrement").value(transformateur.getNum_agrement()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.siret").value(transformateur.getSiret()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.raison_sociale").value(transformateur.getRaison_sociale()));

    }

    @Test
    public void testGetTransformateurByIdNotExists () throws Exception {
        Long id = Integer.toUnsignedLong(22000);

        given (transformateurController.getTransformateurById(id)).willReturn(null);
        mockMvc.perform(get("/transformateur/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetTansformateurBySiretExists () throws Exception {
        String siret = "39931561300584";
        Transformateur transformateur = transformateurRepository.findBySiret(siret).get(0);

        given (transformateurController.getTransformateurBySiret(siret)).willReturn(transformateur);
        mockMvc.perform(get("/transformateur/siret/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.num_agrement").value(transformateur.getNum_agrement()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.siret").value(transformateur.getSiret()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.raison_sociale").value(transformateur.getRaison_sociale()));

    }

    @Test
    public void testGetTransformateurBySiretNotExists () throws Exception {
        String siret = "399315613";

        given (transformateurController.getTransformateurBySiret(siret)).willReturn(null);
        mockMvc.perform(get("/transformateur/siret/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetTansformateurByEstampilleExists () throws Exception {
        String estampille = "02.502.002";
        Transformateur transformateur = transformateurRepository.findByNumAgrement(estampille).get(0);

        given (transformateurController.getTransformateurByEstampille(estampille)).willReturn(transformateur);
        mockMvc.perform(get("/transformateur")
                .param("estampille",estampille)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.num_agrement").value(transformateur.getNum_agrement()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.siret").value(transformateur.getSiret()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.raison_sociale").value(transformateur.getRaison_sociale()));

    }

    @Test
    public void testGetTransformateurByEstampilleNotExists () throws Exception {
        String estampille = "02.502.0048";

        given (transformateurController.getTransformateurByEstampille(estampille)).willReturn(null);
        mockMvc.perform(get("/transformateur")
                .param("estampille", estampille)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }
}
