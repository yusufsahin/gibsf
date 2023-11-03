package com.example.sf400contactmanager;

import com.example.sf400contactmanager.dao.impl.ContactRepositoryImpl;
import com.example.sf400contactmanager.dao.model.Contact;
import com.example.sf400contactmanager.service.impl.ContactServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class ContactServiceImpTest {

    @InjectMocks
    ContactServiceImpl contactService;

    @Mock
    ContactRepositoryImpl contactRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetContactsAsString() {
        when(contactRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Contact(1L, "John", "Doe", "123-456-7890","john@doe.com"),
                        new Contact(2L, "Jane", "Smith", "987-654-3210","jane@doe.com")
                )
        );

        String result = contactService.getContactsAsString();
        assertTrue(result.contains("John"));
        assertTrue(result.contains("Doe"));
        assertTrue(result.contains("Jane"));

    }
}
