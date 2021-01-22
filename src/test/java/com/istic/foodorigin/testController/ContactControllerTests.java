package com.istic.foodorigin.testController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.istic.foodorigin.payload.request.SendComplexEmailRequest;
import com.istic.foodorigin.service.ComplexEmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ComplexEmailService complexEmailService;

    @Test
    public void testSendContactEmail () throws Exception {
        String to = "jerome.georget@free.fr";
        String phone = "0233669988";
        String objet = "Test objet";
        String mess = "Test message";

        SendComplexEmailRequest complexEmail = new SendComplexEmailRequest();
        complexEmail.setEmailAdress(to);
        complexEmail.setMessage(mess);
        complexEmail.setPhoneNumber(phone);
        complexEmail.setSubjet(objet);

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(complexEmail);

        mockMvc.perform(post("/contact/sendEmail")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testSendNotificationEmail () throws Exception {
        String to = "jerome.georget@free.fr";
        String phone = "0233669988";
        String objet = "Test objet";
        String mess = "Test message";

        SendComplexEmailRequest complexEmail = new SendComplexEmailRequest();
        complexEmail.setEmailAdress(to);
        complexEmail.setMessage(mess);
        complexEmail.setPhoneNumber(phone);
        complexEmail.setSubjet(objet);

        ObjectMapper map = new ObjectMapper();
        map.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = map.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(complexEmail);

        mockMvc.perform(post("/contact/notify")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
