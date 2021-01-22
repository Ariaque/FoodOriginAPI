package com.istic.foodorigin.testController;

import com.istic.foodorigin.models.TypeDenree;
import com.istic.foodorigin.repository.TypeDenreeRepository;
import com.istic.foodorigin.service.TypeDenreeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TypeDenreeControllerTests {

    @MockBean
    private TypeDenreeService typeDenreeService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TypeDenreeRepository typeDenreeRepository;

    @Test
    public void testGetAllTypeDenree () throws Exception {
        Iterable<TypeDenree> itDenrees = typeDenreeRepository.findAll();
        List<TypeDenree> liste = StreamSupport.stream(itDenrees.spliterator(), false).collect(Collectors.toList());

        given (typeDenreeService.getAll()).willReturn(liste);
        mockMvc.perform(get("/typeDenree/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(liste.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }

    @Test
    public void testGetAllNomTypeDenree () throws Exception {
        Iterable<TypeDenree> itDenrees = typeDenreeRepository.findAll();
        List<TypeDenree> liste = StreamSupport.stream(itDenrees.spliterator(), false).collect(Collectors.toList());
        List<String> ret = new ArrayList<>();
        for (TypeDenree t: liste) {
            ret.add(t.getNom());
        }
        Set<String> noms = new HashSet<>(ret);

        given (typeDenreeService.getAllNom()).willReturn(noms);
        mockMvc.perform(get("/typeDenree/nom")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(noms.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }

    @Test
    public void testGetEspeceByNomExists () throws Exception {
        String nom = "Produit de la mer";
        Iterable<TypeDenree> itDenrees = typeDenreeRepository.findByNom(nom);
        List<TypeDenree> liste = StreamSupport.stream(itDenrees.spliterator(), false).collect(Collectors.toList());
        List<String> ret = new ArrayList<>();
        for (TypeDenree t: liste) {
            ret.add(t.getEspece());
        }

        Set<String> especes = new HashSet<>(ret);

        given (typeDenreeService.getEspeceByNom(nom)).willReturn(especes);
        mockMvc.perform(get("/typeDenree/espece")
                .contentType(MediaType.APPLICATION_JSON)
                .param("nom", nom))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(especes.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }

    @Test
    public void testGetEspeceByNomNotExists () throws Exception {
        String nom = "Crustacés";
        Iterable<TypeDenree> itDenrees = typeDenreeRepository.findByNom(nom);
        List<TypeDenree> liste = StreamSupport.stream(itDenrees.spliterator(), false).collect(Collectors.toList());
        List<String> ret = new ArrayList<>();
        for (TypeDenree t: liste) {
            ret.add(t.getEspece());
        }
        Set<String> especes = new HashSet<>(ret);

        given (typeDenreeService.getEspeceByNom(nom)).willReturn(especes);
        mockMvc.perform(get("/typeDenree/espece")
                .contentType(MediaType.APPLICATION_JSON)
                .param("nom", nom))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(especes.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }

    @Test
    public void testGetAnimalByEspeceExists () throws Exception {
        String espece = "Poisson";
        Iterable<TypeDenree> itDenrees = typeDenreeRepository.findByEspece(espece);
        List<TypeDenree> liste = StreamSupport.stream(itDenrees.spliterator(), false).collect(Collectors.toList());
        List<String> ret = new ArrayList<>();
        for (TypeDenree t: liste) {
            ret.add(t.getAnimal());
        }
        Set<String> animaux = new HashSet<>(ret);

        given (typeDenreeService.getAnimalByEspece(espece)).willReturn(animaux);
        mockMvc.perform(get("/typeDenree/animal")
                .contentType(MediaType.APPLICATION_JSON)
                .param("espece", espece))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(animaux.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }

    @Test
    public void testGetAnimalByEspeceNotExists () throws Exception {
        String espece = "Papillon";
        Iterable<TypeDenree> itDenrees = typeDenreeRepository.findByEspece(espece);
        List<TypeDenree> liste = StreamSupport.stream(itDenrees.spliterator(), false).collect(Collectors.toList());
        List<String> ret = new ArrayList<>();
        for (TypeDenree t: liste) {
            ret.add(t.getAnimal());
        }

        Set<String> animaux = new HashSet<>(ret);

        given (typeDenreeService.getAnimalByEspece(espece)).willReturn(animaux);
        mockMvc.perform(get("/typeDenree/animal")
                .contentType(MediaType.APPLICATION_JSON)
                .param("espece", espece))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(animaux.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }


}
