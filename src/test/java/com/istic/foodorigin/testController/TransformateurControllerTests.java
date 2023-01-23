package com.istic.foodorigin.testController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.istic.foodorigin.controller.TransformateurController;
import com.istic.foodorigin.dto.OneToOneDto;
import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.repository.GroupeTransformateurRepository;
import com.istic.foodorigin.repository.TransformateurRepository;
import com.istic.foodorigin.service.GroupeTransformateurService;
import com.istic.foodorigin.service.TransformateurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class that tests {@link TransformateurController}
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TransformateurControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransformateurService transformateurService;

    @MockBean
    private GroupeTransformateurService groupeTransformateurService;

    @Autowired
    private TransformateurRepository transformateurRepository;

    @Autowired
    private GroupeTransformateurRepository groupeTransformateurRepository;

    @Test
    public void testGetTansformateurByIdExists() throws Exception {
        Long id = Integer.toUnsignedLong(20);
        Transformateur transformateur = transformateurRepository.findById(id).get();

        given(transformateurService.getTransformateurById(id)).willReturn(transformateur);
        mockMvc.perform(get("/transformateur/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.num_agrement").value(transformateur.getNum_agrement()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.siret").value(transformateur.getSiret()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.raison_sociale").value(transformateur.getRaison_sociale()));
    }

    @Test
    public void testGetTransformateurByIdNotExists() throws Exception {
        Long id = Integer.toUnsignedLong(22000);

        given(transformateurService.getTransformateurById(id)).willReturn(null);
        mockMvc.perform(get("/transformateur/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTransformateurBySiretExists() throws Exception {
        String siret = "37784209100029";
        Transformateur transformateur = transformateurRepository.findBySiret(siret).get(0);

        given(transformateurService.getTransformateurBySiret(siret)).willReturn(transformateur);
        mockMvc.perform(get("/transformateur/siret/{siret}", siret)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.num_agrement").value(transformateur.getNum_agrement()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.siret").value(transformateur.getSiret()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.raison_sociale").value(transformateur.getRaison_sociale()));

    }

    @Test
    public void testGetTransformateurBySiretNotExists() throws Exception {
        String siret = "399315613";

        given(transformateurService.getTransformateurBySiret(siret)).willReturn(null);
        mockMvc.perform(get("/transformateur/siret/{siret}", siret)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTansformateurByEstampilleExists() throws Exception {
        String estampille = "02.502.002";
        Transformateur transformateur = transformateurRepository.findByNumAgrement(estampille).get(0);

        given(transformateurService.getTransformateurByEstampille(estampille)).willReturn(transformateur);
        mockMvc.perform(get("/transformateur")
                        .param("estampille", estampille)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.num_agrement").value(transformateur.getNum_agrement()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.siret").value(transformateur.getSiret()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.raison_sociale").value(transformateur.getRaison_sociale()));

    }

    @Test
    public void testGetTransformateurByEstampilleNotExists() throws Exception {
        String estampille = "02.502.0048";

        given(transformateurService.getTransformateurByEstampille(estampille)).willReturn(null);
        mockMvc.perform(get("/transformateur")
                        .param("estampille", estampille)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindByGroupExist() throws Exception {
        Long groupId = Integer.toUnsignedLong(1);
        List<Transformateur> transformateurL = transformateurRepository.findAllByGroupeTransformateurId(groupId);

        given(transformateurService.getTransformateurByGroupId(groupId)).willReturn(transformateurL);
        mockMvc.perform(get("/transformateur/groupid/{id}", groupId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindByGroupDontExist() throws Exception {
        Long groupId = Integer.toUnsignedLong(1000000000);

        given(transformateurService.getTransformateurByGroupId(groupId)).willReturn(null);
        mockMvc.perform(get("/transformateur/groupid/{id}", groupId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateTransformateur() throws Exception {
        //Make sure that the selected transformer doesn't have a group for this test
        Long id = Integer.toUnsignedLong(22);
        Long groupId = Integer.toUnsignedLong(1);
        Transformateur transformateur = transformateurRepository.findById(id).get();

        given(transformateurService.getTransformateurById(id)).willReturn(transformateur);

        GroupeTransformateur groupeTransformateur = groupeTransformateurRepository.findById(groupId).get();
        given(groupeTransformateurService.getGroupeTransformateurById(groupId)).willReturn(Optional.of(groupeTransformateur));

        OneToOneDto dto = new OneToOneDto(id, groupId);

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dto);

        mockMvc.perform(put("/transformateur/addGroup")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
