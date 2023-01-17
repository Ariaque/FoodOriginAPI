package com.istic.foodorigin.testController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.istic.foodorigin.dto.AddGroupeTransformateurDto;
import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.models.Label;
import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.repository.GroupeTransformateurRepository;
import com.istic.foodorigin.repository.LabelRepository;
import com.istic.foodorigin.service.GroupeTransformateurService;
import com.istic.foodorigin.service.TransformateurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@EnableWebMvc
@AutoConfigureMockMvc
public class GroupeTransformateurControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GroupeTransformateurRepository repository;

    @Autowired
    private LabelRepository labelRepository;

    @MockBean
    private GroupeTransformateurService service;

    @Autowired
    private TransformateurService transformateurService;


    @Test
    public void testCreateGroupeTransformateur() throws Exception {
        String description = "Add groupe groupeTransformateur test";
        Set<Long> labelIds = new HashSet<>(Arrays.asList(1L, 3L));
        Set<Label> labels = new HashSet<>();
        for (Long id : labelIds) {
            labels.add(labelRepository.findById(id).get());
        }

        GroupeTransformateur groupeTransformateur = repository.save(new GroupeTransformateur(labels, description));
        AddGroupeTransformateurDto dto = new AddGroupeTransformateurDto(labelIds, description);

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dto);

        when(service.saveGroupe(groupeTransformateur)).thenReturn(groupeTransformateur);

        mockMvc.perform(post("/groupTransformateur/save")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetGroupeTransformateurById() throws Exception {
        Long id = Integer.toUnsignedLong(1);
        Optional<GroupeTransformateur> groupeTransformateur = repository.findById(id);
        when(service.getGroupeTransformateurById(id)).thenReturn(groupeTransformateur);

        mockMvc.perform(get("/groupTransformateur/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.description").value(groupeTransformateur.get().getDescription()));
    }

    @Test
    public void testGetGroupeTransformateurByInvalidId() throws Exception {
        Long id = Integer.toUnsignedLong(10);
        when(service.getGroupeTransformateurById(id)).thenReturn(Optional.empty());

        mockMvc.perform(get("/groupTransformateur/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAllGroupeTransformateur() throws Exception {
        List<GroupeTransformateur> groupeTransformateurList = StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
        when(service.getAllGroupeTransformateurs()).thenReturn(groupeTransformateurList);

        mockMvc.perform(get("/groupTransformateur/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(groupeTransformateurList.size()));
    }

    @Test
    public void testGetGroupeTransformateurByTranformateurId() throws Exception {
        Long id = Integer.toUnsignedLong(1);

        Transformateur transformateur = transformateurService.getTransformateurById(id);
        transformateur.setGroupeTransformateur(repository.findById(1L).get());
        transformateurService.update(transformateur);

        Optional<GroupeTransformateur> groupeTransformateur = repository.findByTransformateurs_Id(id);
        when(service.findByTransformateurId(id)).thenReturn(groupeTransformateur);

        mockMvc.perform(get("/groupTransformateur/transformateur/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(groupeTransformateur.get().getId()))
                .andExpect(jsonPath("$.description").value(groupeTransformateur.get().getDescription()));
    }

    @Test
    public void testGetGroupeTransformateurByInexistantTranformateurId() throws Exception {
        Long id = Integer.toUnsignedLong(10);
        Optional<GroupeTransformateur> groupeTransformateur = repository.findByTransformateurs_Id(id);
        when(service.findByTransformateurId(id)).thenReturn(groupeTransformateur);

        mockMvc.perform(get("/groupTransformateur/transformateur/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetGroupeTransformateurBylabel() throws Exception {
        String label = "rouge";
        Optional<Set<GroupeTransformateur>> gts = repository.findByLabel(label);
        when(service.findByLabel(label)).thenReturn(gts);

        Set<GroupeTransformateur> groupeTransformateurs = new HashSet<>(gts.get());

        mockMvc.perform(get("/groupTransformateur/label/{label}", label)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(groupeTransformateurs.size()));

        /*String jsonResponse = result.getResponse().getContentAsString();
        Set<GroupeTransformateur> groupeTransformateurList = JsonPath.parse(jsonResponse).read("$.[*]");

        //Check if each groupe transformateur contains in its labels the given string
        boolean contains = groupeTransformateurList.stream()
                .map(GroupeTransforémateur::getLabels)
                .flatMap(Set::stream)
                .anyMatch(l -> l.getLibelle().toLowerCase().contains(label.toLowerCase()));
        assertTrue(contains);*/
    }

    /*@Test




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
    }*/
}
