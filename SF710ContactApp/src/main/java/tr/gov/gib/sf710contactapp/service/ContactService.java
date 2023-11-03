package tr.gov.gib.sf710contactapp.service;

import tr.gov.gib.sf710contactapp.dao.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(int id);
    Contact addContact(Contact contact);
    Contact updateContact(Contact contact);
    void deleteContactById(int id);
}
