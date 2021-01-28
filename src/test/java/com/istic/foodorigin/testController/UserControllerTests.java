package com.istic.foodorigin.testController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.istic.foodorigin.controller.UserController;
import com.istic.foodorigin.models.*;
import com.istic.foodorigin.repository.RoleRepository;
import com.istic.foodorigin.repository.TransformateurRepository;
import com.istic.foodorigin.repository.TypeTransformateurRepository;
import com.istic.foodorigin.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class that tests {@link UserController}
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TransformateurRepository transformateurRepository;

    @Autowired
    private TypeTransformateurRepository typeTransformateurRepository;

    @Test
    public void testGetAll () throws Exception {
        Iterable<User> itUser = userRepository.findAll();
        List<User> user = StreamSupport.stream(itUser.spliterator(), false).collect(Collectors.toList());
        Set<User> ret = new HashSet<>(user);

        mockMvc.perform(get("/user/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(ret.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }


    @Test
    public void testGetRoleUser () throws Exception {
        Iterable<User> itUser = userRepository.findByRole(ERole.ROLE_USER);
        List<User> user = StreamSupport.stream(itUser.spliterator(), false).collect(Collectors.toList());
        Set<User> ret = new HashSet<>(user);

        mockMvc.perform(get("/user/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(ret.size())))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void testSaveUser () throws Exception{
        User user = new User();
        String username = "test@test.fr";
        user.setUsername(username);
        user.setPassword(encoder.encode("test"));
        Role role = roleRepository.findByName(ERole.ROLE_USER).get();
        user.setRole(role);
        Transformateur transformateur = transformateurRepository.findById(Integer.toUnsignedLong(50)).get();
        user.setTransformateur(transformateur);
        TypeTransformateur typeT = typeTransformateurRepository.findById(Integer.toUnsignedLong(2)).get();
        user.setTypeTransformateur(typeT);
        user.setUserActivation(false);
        user.setNumeroTelephone("0298452369");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(user);

        mockMvc.perform(post("/user/save")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUser () throws Exception{
        User user = userRepository.findById(Integer.toUnsignedLong(48)).get();

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(user);

        mockMvc.perform(post("/user/delete")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testDeleteUserNotExists () throws Exception{
        User user = new User();
        user.setUsername("test@admin.fr");
        user.setId(Integer.toUnsignedLong(1));
        user.setNumeroTelephone("0285639874");
        user.setUserActivation(true);
        TypeTransformateur typeT = typeTransformateurRepository.findById(Integer.toUnsignedLong(2)).get();
        user.setTypeTransformateur(typeT);
        Transformateur transformateur = transformateurRepository.findById(Integer.toUnsignedLong(50)).get();
        user.setTransformateur(transformateur);
        Role role = roleRepository.findByName(ERole.ROLE_USER).get();
        user.setRole(role);
        user.setPassword("test");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(user);

        mockMvc.perform(post("/user/delete")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotModified());

    }

    @Test
    public void testGetUserByNameExists () throws Exception {
        String mail = "emile.georget@outlook.fr";
        User user = userRepository.findByUsername(mail).get();

        mockMvc.perform(get("/user/{name}", mail)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(user.getId()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.username").value(user.getUsername()));
    }

    @Test
    public void testGetUserByNameNotExists () throws Exception {
        String mail = "emile.georget@gmail.fr";

        mockMvc.perform(get("/user/{name}", mail)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserByNameNoUser () throws Exception {
        String siret = "30121321100040";

        mockMvc.perform(get("/user/transfo/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserBySiretTransfo () throws Exception {
        String siret = "45060988800018";
        User user = userRepository.findUserBySiret(siret).get();

        mockMvc.perform(get("/user/transfo/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(user.getId()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.username").value(user.getUsername()));
    }

    @Test
    public void testGetUserBySiretUserNotExists () throws Exception {
        String siret = "50879026800017";

        mockMvc.perform(get("/user/transfo/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserBySiretSiretNotExists () throws Exception {
        String siret = "50879026800017157";

        mockMvc.perform(get("/user/transfo/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserStateBySiretActivate () throws Exception {
        String siret = "08678020200031";

        mockMvc.perform(get("/user/isActive/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$").value(true));
    }

    @Test
    public void testGetUserStateBySiretNotActivate () throws Exception {
        String siret = "50308898100017";

        mockMvc.perform(get("/user/isActive/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$").value(false));
    }


    @Test
    public void testGetUserStateBySiretNotExists () throws Exception {
        String siret = "086780202";

        mockMvc.perform(get("/user/isActive/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserStateBySiretNoUser () throws Exception {
        String siret = "95752685801591";

        mockMvc.perform(get("/user/isActive/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserStateByUsernameActivate () throws Exception {
        String username = "edgar.lebreton.35@gmail.com";

        mockMvc.perform(get("/user/activation/{userName}", username)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$").value(true));
    }

    @Test
    public void testGetUserStateByUsernameNotActivate () throws Exception {
        String username = "test@test.fr";

        mockMvc.perform(get("/user/activation/{userName}", username)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$").value(false));
    }

    @Test
    public void testGetUserStateByUsernameNoUser () throws Exception {
        String username = "user";

        mockMvc.perform(get("/user/activation/{userName}", username)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }


    @Test
    public void testGetTransformateurByUserNameExists () throws Exception {
        String username = "edgar.lebreton.35@gmail.com";

        mockMvc.perform(get("/user/transformateur/{userName}", username)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetTransformateurByUserNameNotExists () throws Exception {
        String username = "user";

        mockMvc.perform(get("/user/transformateur/{userName}", username)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserInfosByUserNameExists () throws Exception {
        String username = "edgar.lebreton.35@gmail.com";

        mockMvc.perform(get("/user/userInfos/{userName}", username)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserInfosByUserNameExistsNotExists () throws Exception {
        String username = "user";

        mockMvc.perform(get("/user/transformateur/{userName}", username)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }


}
