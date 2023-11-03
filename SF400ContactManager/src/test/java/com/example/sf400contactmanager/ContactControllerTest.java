package com.example.sf400contactmanager;

import com.example.sf400contactmanager.service.impl.ContactServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactServiceImpl contactService;

    @Test
    public void testGetContactsReturns200AndString() throws Exception {
        String expectedString = "Test string";
        when(contactService.getContactsAsString()).thenReturn(expectedString);

        mockMvc.perform(get("/contacts"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedString));
    }
}
