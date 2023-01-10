package com.istic.foodorigin.testController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.istic.foodorigin.controller.PasswordResetController;
import com.istic.foodorigin.payload.request.ChangePasswordRequest;
import com.istic.foodorigin.payload.request.SavePasswordRequest;
import com.istic.foodorigin.payload.request.SendSimpleEmailRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class that tests {@link PasswordResetController}
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PasswordResetControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSendEmail() throws Exception {
        SendSimpleEmailRequest mailReq = new SendSimpleEmailRequest();
        mailReq.setEmail("jerome.georget@free.fr");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(mailReq);

        mockMvc.perform(post("/reset/resetPassword/sendEmail")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testSendBadEmail() throws Exception {
        SendSimpleEmailRequest mailReq = new SendSimpleEmailRequest();
        mailReq.setEmail("test@gmail.com");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(mailReq);

        mockMvc.perform(post("/reset/resetPassword/sendEmail")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadGateway());
    }

    @Test
    public void testResetPassword() throws Exception {
        Long id = Integer.toUnsignedLong(28);
        String token = "f0901732-4676-46c9-babf-f3e14ef71569";

        mockMvc.perform(get("/reset/resetPassword/validateToken")
                        .param("id", id.toString())
                        .param("token", token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testSavePassword() throws Exception {
        SavePasswordRequest req = new SavePasswordRequest();
        req.setNewPassword("test");
        req.setToken("66fb6350-6da7-498c-9c5e-4921c382f493");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(req);

        mockMvc.perform(post("/reset/resetPassword/savePassword")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testChangePassword() throws Exception {

        ChangePasswordRequest req = new ChangePasswordRequest();
        req.setOldPassword("1234");
        req.setNewPassword("12345");
        req.setUserName("jerome.georget@free.fr");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(req);

        mockMvc.perform(post("/reset/resetPassword/changePassword")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testChangePasswordOlPasswordNotGood() throws Exception {

        ChangePasswordRequest req = new ChangePasswordRequest();
        req.setOldPassword("123456");
        req.setNewPassword("12345");
        req.setUserName("jerome.georget@free.fr");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(req);

        mockMvc.perform(post("/reset/resetPassword/changePassword")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadGateway());

    }

    @Test
    public void testChangePasswordUsernameNotExists() throws Exception {

        ChangePasswordRequest req = new ChangePasswordRequest();
        req.setOldPassword("test");
        req.setNewPassword("test2");
        req.setUserName("a@gmail.com");

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(req);

        mockMvc.perform(post("/reset/resetPassword/changePassword")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadGateway());

    }
}
