package com.example.sf400contactmanager;

import com.example.sf400contactmanager.dao.impl.ContactRepositoryImpl;
import com.example.sf400contactmanager.dao.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ContactRepositoryImplTest {
    private ContactRepositoryImpl contactRepository;

    @BeforeEach
    void setup() {
        contactRepository = new ContactRepositoryImpl();
    }

    @Test
    void testFindAll() {

        Contact contact1 = new Contact(1L, "John", "Doe", "123345", "john@doe.com");
        Contact contact2 = new Contact(2L, "Jane", "Doe", "123346", "jane@doe.com");
        contactRepository.save(contact1);
        contactRepository.save(contact2);

        List<Contact> contacts = contactRepository.findAll();
        assertEquals(2, contacts.size());
    }

    @Test
    void testFindById() {
        Contact contact1=new Contact(1L,"John","Doe","123345","john@doe.com");
        contactRepository.save(contact1);
        Contact found= contactRepository.findById(1L);

        assertEquals("John",found.getFirstname());
    }

    @Test
    void testSave() {
        Contact contact = new Contact(1L, "John", "Doe", "123-456-7890","john@doe.com");
        contactRepository.save(contact);

        Contact found = contactRepository.findById(1L);
        assertEquals("John", found.getFirstname());
    }
    @Test
    void testDeleteById() {
        Contact contact = new Contact(1L, "John", "Doe", "123-456-7890","john@doe.com");
        contactRepository.save(contact);

        contactRepository.delete(1L);

        Contact found = contactRepository.findById(1L);
        assertNull(found);
    }
}