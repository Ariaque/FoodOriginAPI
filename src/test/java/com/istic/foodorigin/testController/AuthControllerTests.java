package com.istic.foodorigin.testController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.istic.foodorigin.payload.request.LoginRequest;
import com.istic.foodorigin.payload.request.SignupRequest;
import com.istic.foodorigin.repository.RoleRepository;
import com.istic.foodorigin.repository.TypeTransformateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TypeTransformateurRepository typeTRepository;

    @Test
    public void testAuthenticateUser () throws Exception{
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("aqw@gmail.com");
        loginRequest.setPassword("test");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(loginRequest);

        mockMvc.perform(post("/auth/signin")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAuthenticateUserNotExists () throws Exception{
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("emile.georget@admin.fr");
        loginRequest.setPassword("admin1");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(loginRequest);

        mockMvc.perform(post("/auth/signin")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testAuthenticateMdpNotGood () throws Exception{
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("emile.georget@outlook.fr");
        loginRequest.setPassword("test");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(loginRequest);

        mockMvc.perform(post("/auth/signin")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testAuthenticateNotExists () throws Exception{
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("emile.georget@admin.fr");
        loginRequest.setPassword("admin35");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(loginRequest);

        mockMvc.perform(post("/auth/signin")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testRegisterUser () throws Exception{
        SignupRequest signupRequest = new SignupRequest();
        String siret = "30021990400327";
        Set<String> roles = new HashSet<String>();
        roles.add("user");
        signupRequest.setNumeroTelephone("0299874536");
        signupRequest.setPassword("test");
        signupRequest.setRole(roles);
        signupRequest.setTypeTransformateur(typeTRepository.findByLibelle("Artisan").getLibelle());
        signupRequest.setUsername("test@test.fr");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(signupRequest);

        mockMvc.perform(post("/auth/signup/{siret}",siret)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testRegisterUserAlreadyExists () throws Exception{
        SignupRequest signupRequest = new SignupRequest();
        String siret = "30021990400327";
        Set<String> roles = new HashSet<String>();
        roles.add("user");
        signupRequest.setNumeroTelephone("0299874536");
        signupRequest.setPassword("test");
        signupRequest.setRole(roles);
        signupRequest.setTypeTransformateur(typeTRepository.findByLibelle("Artisan").getLibelle());
        signupRequest.setUsername("emile.georget@outlook.fr");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(signupRequest);

        mockMvc.perform(post("/auth/signup/{siret}",siret)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Erreur: Ce nom d'utilisateur est déjà pris !"));
    }

    @Test
    public void testRegisterUserSiretAlreadyExists () throws Exception{
        SignupRequest signupRequest = new SignupRequest();
        String siret = "08678020200031";
        Set<String> roles = new HashSet<String>();
        roles.add("user");
        signupRequest.setNumeroTelephone("0299874536");
        signupRequest.setPassword("test");
        signupRequest.setRole(roles);
        signupRequest.setTypeTransformateur(typeTRepository.findByLibelle("Artisan").getLibelle());
        signupRequest.setUsername("test2@gmail.fr");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(signupRequest);

        mockMvc.perform(post("/auth/signup/{siret}",siret)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Erreur: Un compte existe déjà pour ce Siret!"));
    }

    @Test
    public void testRegisterUserSiretNotExists () throws Exception{
        SignupRequest signupRequest = new SignupRequest();
        String siret = "0867802020003112369";
        Set<String> roles = new HashSet<String>();
        roles.add("user");
        signupRequest.setNumeroTelephone("0299874536");
        signupRequest.setPassword("test");
        signupRequest.setRole(roles);
        signupRequest.setTypeTransformateur(typeTRepository.findByLibelle("Artisan").getLibelle());
        signupRequest.setUsername("test2@gmail.fr");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(signupRequest);

        mockMvc.perform(post("/auth/signup/{siret}",siret)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Erreur: Ce Siret n'est pas enregistré dans notre base de données !"));
            ;
    }


}
