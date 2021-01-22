package com.istic.foodorigin.testController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.istic.foodorigin.controller.InfosTransformateurController;
import com.istic.foodorigin.models.*;
import com.istic.foodorigin.repository.InfosTransformateurRepository;
import com.istic.foodorigin.repository.TransformateurRepository;
import com.istic.foodorigin.service.ImageService;
import com.istic.foodorigin.service.InfosTransformateurService;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InfosTControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InfosTransformateurService infosTService;

    @MockBean
    private ImageService imageService;

    @Autowired
    private InfosTransformateurRepository infosTRepository;

    @Autowired
    private TransformateurRepository transformateurRepository;

    @Test
    public void testGetInfosByIdExists () throws Exception {
        Long id = Integer.toUnsignedLong(4);
        InfosTransformateur infos = infosTRepository.findById(id).get();

        given (infosTService.getInfosById(id)).willReturn(infos);
        mockMvc.perform(get("/infoTransformateur/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect (MockMvcResultMatchers.jsonPath("$.description").value(infos.getDescription()));
    }

    @Test
    public void testGetInfosByIdNotExists () throws Exception {
        Long id = Integer.toUnsignedLong(1);

        given (infosTService.getInfosById(id)).willReturn(null);
        mockMvc.perform(get("/infoTransformateur/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testSaveInfosTrans () throws Exception{
        InfosTransformateur infos = new InfosTransformateur();
        String description = "Exemple de présentation d'une usine";
        infos.setDescription(description);
        Transformateur transformateur = transformateurRepository.findById(Integer.toUnsignedLong(22)).get();
        infos.setTransformateur(transformateur);

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(infos);

        given (infosTService.saveInfos(infos)).willReturn(infos);
        mockMvc.perform(post("/infoTransformateur")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetInfosByTransformateurExists () throws Exception {
        Long id = Integer.toUnsignedLong(1);
        Transformateur transformateur = transformateurRepository.findById(id).get();
        InfosTransformateur infos = infosTRepository.findByTransformateur(transformateur);

        given (infosTService.getInfosByTransformateur(id)).willReturn(infos);
        mockMvc.perform(get("/infoTransformateur/transformateur/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(infos.getId()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.description").value(infos.getDescription()));
    }

    @Test
    public void testGetInfosByTransformateurNoInfos () throws Exception {
        Long id = Integer.toUnsignedLong(55);

        given (infosTService.getInfosById(id)).willReturn(null);
        mockMvc.perform(get("/infoTransformateur/transformateur/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetInfosByTransformateurNotExists () throws Exception {
        Long id = Integer.toUnsignedLong(25000);

        given (infosTService.getInfosById(id)).willReturn(null);
        mockMvc.perform(get("/infoTransformateur/transformateur/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void saveImage () throws Exception{
        Long id = Integer.toUnsignedLong(1);
        File image = new File ("D:\\Yaelle\\Mes documents\\M2 MIAGE\\Projet\\FoodOriginAPI\\src\\test\\java\\com\\istic\\foodorigin\\foodorigintransp.png");
        FileInputStream input = new FileInputStream(image);
        MockMultipartFile file = new MockMultipartFile("fileItem", image.getName(), "image/png", IOUtils.toByteArray(input));

        given (imageService.saveImageOnServer(file,id)).willReturn(true);
        mockMvc.perform(multipart("/infoTransformateur/images/{id}", id).file("myFile", file.getBytes()))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetImagesLinkIdExists () throws Exception {
        Long id = Integer.toUnsignedLong(1);
        Set<String> imagesL = new HashSet<>();
        imagesL.add("index.jpg");
        imagesL.add("index.png");
        imagesL.add("shutterstock_194313791.jpg");

        given (imageService.getFolderFiles(id)).willReturn(imagesL);
        mockMvc.perform(get("/infoTransformateur/images/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(imagesL.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }

    @Test
    public void testGetImagesLinkIdExistsNoPhoto () throws Exception {
        Long id = Integer.toUnsignedLong(33);
        Set<String> imagesL = new HashSet<>();

        given (imageService.getFolderFiles(id)).willReturn(imagesL);
        mockMvc.perform(get("/infoTransformateur/images/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(imagesL.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void testGetImagesLinkIdNotExists () throws Exception {
        Long id = Integer.toUnsignedLong(250000);
        Set<String> imagesL = new HashSet<>();

        given (imageService.getFolderFiles(id)).willReturn(imagesL);
        mockMvc.perform(get("/infoTransformateur/images/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(imagesL.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void testDeleteImageIdExists () throws Exception {
        Long id = Integer.toUnsignedLong(0);
        String file = "foodorigintransp.png";
        String fileName = "foodorigin.projetetudiant.fr/images/0/foodorigintransp.png";

        given (imageService.removeFile(id, file)).willReturn(true);
        mockMvc.perform(post("/infoTransformateur/images/delete/{id}", id)
                .content(fileName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$").value(true));

    }

    @Test
    public void testDeleteImageIdExistsNoPhoto () throws Exception {
        Long id = Integer.toUnsignedLong(1);
        String fileName = "http://foodorigin.projetetudiant.fr/images/5/image.png";

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(fileName);


        given (imageService.removeFile(id, fileName)).willReturn(false);
        mockMvc.perform(post("/infoTransformateur/images/delete/{id}", id)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$").value(false));
    }

    @Test
    public void testDeletImageIdNotExists () throws Exception {
        Long id = Integer.toUnsignedLong(23000);
        String fileName = "http://foodorigin.projetetudiant.fr/images/5/image.png";

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(fileName);

        given (imageService.removeFile(id, fileName)).willReturn(false);
        mockMvc.perform(post("/infoTransformateur/images/delete/{id}", id)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$").value(false));
    }

}
