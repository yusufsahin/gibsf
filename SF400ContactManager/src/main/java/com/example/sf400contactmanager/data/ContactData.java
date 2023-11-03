package com.example.sf400contactmanager.data;

import com.example.sf400contactmanager.dao.ContactRepository;
import com.example.sf400contactmanager.dao.impl.ContactRepositoryImpl;
import com.example.sf400contactmanager.dao.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)

public class ContactData implements CommandLineRunner {
    private final ContactRepositoryImpl contactRepository;

    @Autowired
    public ContactData(ContactRepositoryImpl contactRepository) {
        this.contactRepository = contactRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        contactRepository.save(new Contact(1L, "John", "Doe", "123-456-7890","john@doe.com"));
        contactRepository.save(new Contact(2L, "Jane", "Smith", "987-654-3210","jane@doe.com"));
    }
}