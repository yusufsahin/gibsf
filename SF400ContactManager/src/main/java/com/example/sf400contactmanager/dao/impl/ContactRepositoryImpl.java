package com.example.sf400contactmanager.dao.impl;

import com.example.sf400contactmanager.dao.ContactRepository;
import com.example.sf400contactmanager.dao.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactRepositoryImpl implements ContactRepository {
    private  List<Contact> contacts= new ArrayList<>();

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public Contact findById(Long id) {
        return contacts.stream().filter(contact -> contact.getId().equals(id)).findFirst().orElse(null);
    }
    @Override
    public void save(Contact contact) {

        Contact existingContact= findById(contact.getId());

        if(existingContact==null){
            contacts.add(contact);
        }else {
            existingContact.setFirstname(contact.getFirstname());
            existingContact.setLastname(contact.getLastname());
            existingContact.setPhonenumber(contact.getPhonenumber());
            existingContact.setEmail(contact.getEmail());
        }
    }

    @Override
    public void delete(Long id) {
        contacts.removeIf(contact -> contact.getId().equals(id));

    }
}
