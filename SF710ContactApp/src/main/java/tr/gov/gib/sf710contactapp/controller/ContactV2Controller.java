package tr.gov.gib.sf710contactapp.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;
import tr.gov.gib.sf710contactapp.dao.model.Contact;
import tr.gov.gib.sf710contactapp.service.impl.ContactServiceImpl;

import java.util.List;
import java.util.stream.Collectors;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/contacts")
public class ContactV2Controller {
    private final ContactServiceImpl contactService;

    public ContactV2Controller(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<EntityModel<Contact>> getAllContacts()
    {
        return  contactService.getAllContacts().stream()
                .map(
                        contact -> EntityModel.of(
                                contact,
                                linkTo(methodOn(ContactV2Controller.class).getContactById(contact.getId())).withSelfRel(),
                                linkTo(methodOn(ContactV2Controller.class).getAllContacts()).withRel("contacts")
                        ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntityModel<Contact> getContactById(@PathVariable int id) {
        Contact contact = contactService.getContactById(id);
        Link selfLink = linkTo(methodOn(ContactV2Controller.class).getContactById(id)).withSelfRel();
        return EntityModel.of(contact, selfLink);
    }
    @PostMapping
    public EntityModel<Contact> addContact(@RequestBody Contact contact) {
        Contact newContact = contactService.addContact(contact);
        return EntityModel.of(
                newContact,
                linkTo(methodOn(ContactV2Controller.class).getContactById(newContact.getId())).withSelfRel()
        );
    }



    @PutMapping
    public EntityModel<Contact> updateContact(@RequestBody Contact contact) {
        Contact updatedContact = contactService.updateContact(contact);
        return EntityModel.of(
                updatedContact,
                linkTo(methodOn(ContactV2Controller.class).getContactById(updatedContact.getId())).withSelfRel()
        );
    }

    @PatchMapping("/{id}")
    public EntityModel<Contact> partialUpdateContact(@PathVariable int id, @RequestBody Contact contact) {
        Contact existingContact = contactService.getContactById(id);
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
            Contact updatedContact = contactService.updateContact(existingContact);
            return EntityModel.of(
                    updatedContact,
                    linkTo(methodOn(ContactV2Controller.class).getContactById(updatedContact.getId())).withSelfRel()
            );
        }
        return null;

    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable int id) {
        contactService.deleteContactById(id);
    }
}
