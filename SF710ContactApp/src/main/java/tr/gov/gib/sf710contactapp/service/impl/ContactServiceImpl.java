package tr.gov.gib.sf710contactapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.gov.gib.sf710contactapp.dao.dao.impl.ContactRepositoryImpl;
import tr.gov.gib.sf710contactapp.dao.model.Contact;
import tr.gov.gib.sf710contactapp.service.ContactService;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepositoryImpl contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.getAll();
    }

    @Override
    public Contact getContactById(int id) {
        return contactRepository.getById(id);
    }

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.insert(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.update(contact);
    }

    @Override
    public void deleteContactById(int id) {
        contactRepository.deleteById(id);
    }
}
