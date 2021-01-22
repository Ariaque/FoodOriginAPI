package com.istic.foodorigin.testController;

import com.istic.foodorigin.models.TypeTransformateur;
import com.istic.foodorigin.repository.TypeTransformateurRepository;
import com.istic.foodorigin.service.TypeTransformateurService;
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
public class TypeTransformateurTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TypeTransformateurService typeTService;

    @Autowired
    private TypeTransformateurRepository typeTRepository;

    @Test
    public void testGetAll () throws Exception {
        Iterable<TypeTransformateur> itTypeT = typeTRepository.findAll();
        List<TypeTransformateur> typesT = StreamSupport.stream(itTypeT.spliterator(), false).collect(Collectors.toList());

        given (typeTService.getAllType()).willReturn(typesT);
        mockMvc.perform(get("/typeTransformateur/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(typesT.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void testGetTypeTransformateurByIdExists () throws Exception {
        Long id = Integer.toUnsignedLong(2);
        TypeTransformateur typeArtisan = typeTRepository.findById(id).get();

        given (typeTService.getTypeById(id)).willReturn(typeArtisan);
        mockMvc.perform(get("/typeTransformateur/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect (MockMvcResultMatchers.jsonPath("$.libelle").value(typeArtisan.getLibelle()));

    }

    @Test
    public void testGetTypeTransformateurByIdNotExists () throws Exception {
        Long id = Integer.toUnsignedLong(52);

        given (typeTService.getTypeById(id)).willReturn(null);
        mockMvc.perform(get("/typeTransformateur/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }
}
