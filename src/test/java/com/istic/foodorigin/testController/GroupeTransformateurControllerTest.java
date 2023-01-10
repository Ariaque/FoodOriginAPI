/*
package com.istic.foodorigin.testController;

import com.istic.foodorigin.controller.GroupeTransformateurController;
import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.repository.GroupeTransformateurRepository;
import com.istic.foodorigin.service.GroupeTransformateurService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GroupeTransformateurControllerTest {

    @InjectMocks
    private GroupeTransformateurController controller;

    @Autowired
    private GroupeTransformateurRepository repository;

    @MockBean
    private GroupeTransformateurService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetGroupeTransformateurById() throws Exception {
        Long id = Integer.toUnsignedLong(1);
        GroupeTransformateur groupeTransformateur = repository.findById(id).get();
        when(service.getGroupeTransformateurById(id)).thenReturn(groupeTransformateur);

        mockMvc.perform(get("/groupTransformateur/{id}", id))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("groupe1"));
    }

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
    */
/*
    @Test
    public void testGetGroupeTransformateurByInvalidId() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/groupTransformateur/{id}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateGroupeTransformateur() throws Exception {
        GroupeTransformateur groupeTransformateur = new GroupeTransformateur(1L, new HashSet<>(), "groupe1", new HashSet<>());

        when(repository.save(groupeTransformateur)).thenReturn(groupeTransformateur);

        mockMvc.perform(post("/groupTransformateur")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.description").value("groupe1"));

        verify(repository, times(1)).save(groupeTransformateur);
    }

    @Test
    public void testUpdateGroupeTransformateur() throws Exception {
        GroupeTransformateur groupeTransformateur = new GroupeTransformateur(1L, new HashSet<>(), "groupe1", new HashSet<>());
        when(repository.findById(1L)).thenReturn(Optional.of(groupeTransformateur));

        GroupeTransformateur updatedGroupeTransformateur = new GroupeTransformateur(1L, new HashSet<>(), "groupe1 updated", new HashSet<>());
        when(repository.save(updatedGroupeTransformateur)).thenReturn(updatedGroupeTransformateur);

        mockMvc.perform(put("/groupTransformateur/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.description").value("groupe1 updated"));
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(updatedGroupeTransformateur);
    }

    @Test
    public void testUpdateGroupeTransformateurWithInvalidId() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        GroupeTransformateur updatedGroupeTransformateur = new GroupeTransformateur(1L, new HashSet<>(), "groupe1 updated", new HashSet<>());

        mockMvc.perform(put("/groupTransformateur/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(repository, times(1)).findById(1L);
        verify(repository, times(0)).save(updatedGroupeTransformateur);
    }

    @Test
    public void testDeleteGroupeTransformateur() throws Exception {
        GroupeTransformateur groupeTransformateur = new GroupeTransformateur(1L, new HashSet<>(), "groupe1", new HashSet<>());
        when(repository.findById(1L)).thenReturn(Optional.of(groupeTransformateur));

        mockMvc.perform(delete("/groupTransformateur/{id}", 1L))
                .andExpect(status().isOk());

        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).delete(groupeTransformateur);
    }

    @Test
    public void testDeleteGroupeTransformateurWithInvalidId() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/groupTransformateur/{id}", 1L))
                .andExpect(status().isNotFound());

        verify(repository, times(1)).findById(1L);
        verify(repository, times(0)).delete(any(GroupeTransformateur.class));
    }*//*

}
*/
