package com.istic.foodorigin.testController;

import com.istic.foodorigin.models.OrigineDenree;
import com.istic.foodorigin.repository.OrigineDenreeRepository;
import com.istic.foodorigin.service.OrigineDenreeService;
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
public class OrigineDenreeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrigineDenreeRepository origineDenreeRepository;

    @MockBean
    private OrigineDenreeService origineDenreeService;

    @Test
    public void testGetAll () throws Exception {
        Iterable<OrigineDenree> itOrigine = origineDenreeRepository.findAll();
        List<OrigineDenree> liste = StreamSupport.stream(itOrigine.spliterator(), false).collect(Collectors.toList());

        given (origineDenreeService.getAllOrigineDenree()).willReturn(liste);
        mockMvc.perform(get("/origineDenree/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(liste.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }

    @Test
    public void testGetAllNomPays () throws Exception {
        Iterable<OrigineDenree> itOrigine = origineDenreeRepository.findAll();
        List<OrigineDenree> liste = StreamSupport.stream(itOrigine.spliterator(), false).collect(Collectors.toList());
        List<String> ret = new ArrayList<>();
        for (OrigineDenree t: liste) {
            ret.add(t.getPays());
        }
        Set<String> pays = new HashSet<>(ret);

        given (origineDenreeService.getAllPays()).willReturn(pays);
        mockMvc.perform(get("/origineDenree/pays")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(pays.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }

    @Test
    public void testGetRegionByPays () throws Exception {
        String pays = "France";
        Iterable<OrigineDenree> itDenrees = origineDenreeRepository.findByPays(pays);
        List<OrigineDenree> liste = StreamSupport.stream(itDenrees.spliterator(), false).collect(Collectors.toList());
        List<String> ret = new ArrayList<>();
        for (OrigineDenree t: liste) {
            ret.add(t.getPays());
        }
        Set<String> regions = new HashSet<>(ret);

        given (origineDenreeService.getRegionByPays(pays)).willReturn(regions);
        mockMvc.perform(get("/origineDenree/regions")
                .contentType(MediaType.APPLICATION_JSON)
                .param("pays", pays))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(regions.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }

    @Test
    public void testGetEspeceByNomNotExists () throws Exception {
        String pays = "Brésil";
        Iterable<OrigineDenree> itDenrees = origineDenreeRepository.findByPays(pays);
        List<OrigineDenree> liste = StreamSupport.stream(itDenrees.spliterator(), false).collect(Collectors.toList());
        List<String> ret = new ArrayList<>();
        for (OrigineDenree t: liste) {
            ret.add(t.getPays());
        }
        Set<String> regions = new HashSet<>(ret);

        given (origineDenreeService.getRegionByPays(pays)).willReturn(regions);
        mockMvc.perform(get("/origineDenree/regions")
                .contentType(MediaType.APPLICATION_JSON)
                .param("pays", pays))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(regions.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }
}
