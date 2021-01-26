package com.istic.foodorigin.testController;

import com.istic.foodorigin.controller.FermePartenaireController;
import com.istic.foodorigin.models.FermePartenaire;
import com.istic.foodorigin.repository.FermePartenaireRepository;
import com.istic.foodorigin.service.FermePartenaireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class that tests {@link FermePartenaireController}
 */
@SpringBootTest
@AutoConfigureMockMvc
public class FermePartenaireControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FermePartenaireService fermePartenaireService;

    @Autowired
    private FermePartenaireRepository fermePRepository;

    @Test
    public void testGetAll () throws Exception {
        Iterable<FermePartenaire> itFerme = fermePRepository.findAll();
        List<FermePartenaire> fermes = StreamSupport.stream(itFerme.spliterator(), false).collect(Collectors.toList());
        Set<FermePartenaire> ret = new HashSet<>(fermes);

        given (fermePartenaireService.getAllFermes()).willReturn(ret);
        mockMvc.perform(get("/ferme/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(fermes.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void testGetFermeByIdExists () throws Exception {
        Long id = Integer.toUnsignedLong(58);
        FermePartenaire ferme = fermePRepository.findById(id).get();

        given (fermePartenaireService.getFermeById(id)).willReturn(ferme);
        mockMvc.perform(get("/ferme/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect (MockMvcResultMatchers.jsonPath("$.nom").value(ferme.getNom()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.description").value(ferme.getDescription()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.url").value(ferme.getUrl()));

    }

    @Test
    public void testGetFermeByIdNotExists () throws Exception {
        Long id = Integer.toUnsignedLong(15);

        given (fermePartenaireService.getFermeById(id)).willReturn(null);
        mockMvc.perform(get("/ferme/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }
}
