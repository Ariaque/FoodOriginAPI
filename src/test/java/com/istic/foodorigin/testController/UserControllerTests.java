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
import com.istic.foodorigin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @MockBean
    private UserController userController;

    @MockBean
    private UserService userService;

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

        given (userController.getAllUsers()).willReturn(ret);
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

        given (userController.getAllRoleUser()).willReturn(ret);
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

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(user);

        given (userController.saveUser(user)).willReturn(user);
        mockMvc.perform(post("/user/save")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUser () throws Exception{
        User user = new User();
        String username = "test@gmail.com";
        user.setUsername(username);

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(user);

        given (userService.deleteUser(user)).willReturn(true);
        mockMvc.perform(post("/user/delete")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testDeleteUserNotExists () throws Exception{
        User user = new User();
        String username = "test@test.fr";
        user.setUsername(username);

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(user);

        given (userService.deleteUser(user)).willReturn(false);
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

        given (userController.getUserByName(mail)).willReturn(user);
        mockMvc.perform(get("/user/{name}", mail)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(user.getId()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.username").value(user.getUsername()));
    }

    @Test
    public void testGetUserByName () throws Exception {
        String mail = "emile.georget@gmail.fr";

        given (userController.getUserByName(mail)).willReturn(null);
        mockMvc.perform(get("/user/{name}", mail)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserBySiretTransfo () throws Exception {
        String siret = "37784209100029";
        User user = userRepository.findUserBySiret(siret).get();

        given (userController.getUserBySiretTransfo(siret)).willReturn(user);
        mockMvc.perform(get("/user/transfo/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$.id").value(user.getId()))
                .andExpect (MockMvcResultMatchers.jsonPath("$.username").value(user.getUsername()));
    }

    @Test
    public void testGetUserByNameNotExists () throws Exception {
        String siret = "377842091";

        given (userController.getUserBySiretTransfo(siret)).willReturn(null);
        mockMvc.perform(get("/user/transfo/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserByNameNoUser () throws Exception {
        String siret = "30121321100040";

        given (userController.getUserBySiretTransfo(siret)).willReturn(null);
        mockMvc.perform(get("/user/transfo/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserStateBySiretActivate () throws Exception {
        String siret = "08678020200031";

        given (userController.getUserStateBySiret(siret)).willReturn(true);
        mockMvc.perform(get("/user/isActive/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$").value(true));
    }

    @Test
    public void testGetUserStateBySiretNotActivate () throws Exception {
        String siret = "33398522400018";

        given (userController.getUserStateBySiret(siret)).willReturn(false);
        mockMvc.perform(get("/user/isActive/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk())
                .andExpect (MockMvcResultMatchers.jsonPath("$").value(false));
    }


    @Test
    public void testGetUserStateBySiretNotExists () throws Exception {
        String siret = "086780202";

        given (userController.getUserStateBySiret(siret)).willReturn(null);
        mockMvc.perform(get("/user/isActive/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

    @Test
    public void testGetUserStateBySiretNoUser () throws Exception {
        String siret = "55382046500761";

        given (userController.getUserBySiretTransfo(siret)).willReturn(null);
        mockMvc.perform(get("/user/isActive/{siret}", siret)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect (status().isOk());
    }

}
