package com.istic.foodorigin.testController;

import com.istic.foodorigin.controller.UrlVideoController;
import com.istic.foodorigin.models.UrlVideo;
import com.istic.foodorigin.repository.UrlVideoRepository;
import com.istic.foodorigin.service.UrlVideoService;
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
 * Class that tests {@link UrlVideoController}
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UrlVideoControllerTests {

    @MockBean
    private UrlVideoService urlVideoService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UrlVideoRepository urlVideoRepository;

    @Test
    public void testGetAllUrls() throws Exception {
        Iterable<UrlVideo> itVideos = urlVideoRepository.findAll();
        List<UrlVideo> urlVideos = StreamSupport.stream(itVideos.spliterator(), false).collect(Collectors.toList());
        Set<UrlVideo> urls = new HashSet<>(urlVideos);

        given(urlVideoService.getAllUrls()).willReturn(urls);
        mockMvc.perform(get("/urlVideo/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(urls.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void testGetUrlByIdExists() throws Exception {
        Long id = Integer.toUnsignedLong(39);
        UrlVideo urlVideo = urlVideoRepository.findById(id).get();

        given(urlVideoService.getUrlById(id)).willReturn(urlVideo);
        mockMvc.perform(get("/urlVideo/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.libelle").value(urlVideo.getLibelle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.titre").value(urlVideo.getTitre()));

    }

    @Test
    public void testGetUrlByIdNotExists() throws Exception {
        Long id = Integer.toUnsignedLong(12);

        given(urlVideoService.getUrlById(id)).willReturn(null);
        mockMvc.perform(get("/urlVideo/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
