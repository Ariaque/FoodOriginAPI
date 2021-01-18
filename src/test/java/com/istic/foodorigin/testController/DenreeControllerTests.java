package com.istic.foodorigin.testController;

import com.istic.foodorigin.controller.DenreeController;
import com.istic.foodorigin.models.DenreeAnimale;
import com.istic.foodorigin.repository.DenreeAnimaleRepository;
import com.istic.foodorigin.service.DenreeAnimaleService;
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

@SpringBootTest
@AutoConfigureMockMvc
public class DenreeControllerTests {

    @MockBean
    private DenreeController denreeAController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DenreeAnimaleRepository denreeARepository;


    @Test
    public void testGetAll () throws Exception {
        Iterable<DenreeAnimale> itDenree = denreeARepository.findAll();
        List<DenreeAnimale> denrees = StreamSupport.stream(itDenree.spliterator(), false).collect(Collectors.toList());
        Set<DenreeAnimale> ret = new HashSet<>(denrees);

        given (denreeAController.getAll()).willReturn(ret);
        mockMvc.perform(get("/denree/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(denrees.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void testGetDenreeByIdExists () throws Exception {
        Long id = Integer.toUnsignedLong(45);
        DenreeAnimale denreeAnimale = denreeARepository.findById(id).get();

        given (denreeAController.getDenreeById(id)).willReturn(denreeAnimale);
        mockMvc.perform(get("/denree/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect (MockMvcResultMatchers.jsonPath("$.nom").value(denreeAnimale.getNom()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.origine").value(denreeAnimale.getOrigine()));
    }

    @Test
    public void testGetDenreeByIdNotExists () throws Exception {
        Long id = Integer.toUnsignedLong(10);

        given (denreeAController.getDenreeById(id)).willReturn(null);
        mockMvc.perform(get("/denree/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

}
