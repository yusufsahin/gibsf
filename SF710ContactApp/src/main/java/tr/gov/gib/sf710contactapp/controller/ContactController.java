package tr.gov.gib.sf710contactapp.controller;

import org.springframework.web.bind.annotation.*;
import tr.gov.gib.sf710contactapp.dao.model.Contact;
import tr.gov.gib.sf710contactapp.service.impl.ContactServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final ContactServiceImpl service;

    public ContactController(ContactServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Contact> getAllContacts(){

        return service.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable int id)
    {
        return  service.getContactById(id);
    }

    @PostMapping
    public Contact addContact(@RequestBody Contact contact)
    {
        return service.addContact(contact);
    }
    @PutMapping("/{id}")
    public Contact updateContact(@RequestBody Contact contact)
    {
        return service.updateContact(contact);
    }

    @PatchMapping("/{id}")
    public Contact partialUpdateContact(@PathVariable int id, @RequestBody Contact contact) {
        Contact existingContact = service.getContactById(id);
        if (existingContact != null) {
            if (contact.getFirstname() != null) {
                existingContact.setFirstname(contact.getFirstname());
            }
            if (contact.getLastname() != null) {
                existingContact.setLastname(contact.getLastname());
            }
            if (contact.getPhonenumber() != null) {
                existingContact.setPhonenumber(contact.getPhonenumber());
            }
            if (contact.getEmail() != null) {
                existingContact.setEmail(contact.getEmail());
            }
            return service.updateContact(existingContact);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable int id)
    {
        service.deleteContactById(id);
    }
}
