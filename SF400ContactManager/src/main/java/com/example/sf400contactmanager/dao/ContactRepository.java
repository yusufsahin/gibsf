package com.example.sf400contactmanager.dao;

import com.example.sf400contactmanager.dao.model.Contact;

import java.util.List;

public interface ContactRepository {
    List<Contact> findAll();
    Contact findById(Long id);
    void save(Contact contact);
    void delete(Long id);
}
