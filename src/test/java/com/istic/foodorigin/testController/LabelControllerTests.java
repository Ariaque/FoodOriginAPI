package com.istic.foodorigin.testController;

import com.istic.foodorigin.models.Label;
import com.istic.foodorigin.repository.LabelRepository;
import com.istic.foodorigin.service.LabelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;;
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
public class LabelControllerTests {

    @MockBean
    private LabelService labelService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private LabelRepository labelRepository;

    @Test
    public void testGetAllLabels () throws Exception {
        Iterable<Label> itLabel = labelRepository.findAll();
        List<Label> labels = StreamSupport.stream(itLabel.spliterator(), false).collect(Collectors.toList());
        Set <Label> ret = new HashSet<>(labels);

        given (labelService.getAllLabels()).willReturn(ret);
        mvc.perform(get("/label/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(labels.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void testGetLabelById () throws Exception {
        Long id = Integer.toUnsignedLong(1);
        Label l1 = labelRepository.findById(id).get();

        given (labelService.getLabelById(id)).willReturn(l1);
        mvc.perform(get("/label/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect (MockMvcResultMatchers.jsonPath("$.libelle").value(l1.getLibelle()));

    }

    @Test
    public void testGetLabelByIdNotExists () throws Exception {
        Long id = Integer.toUnsignedLong(25);

        given (labelService.getLabelById(id)).willReturn(null);
        mvc.perform(get("/label/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }
}

