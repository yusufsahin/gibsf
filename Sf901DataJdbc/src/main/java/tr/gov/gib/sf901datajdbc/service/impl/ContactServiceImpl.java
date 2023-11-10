package tr.gov.gib.sf901datajdbc.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tr.gov.gib.sf901datajdbc.dao.ContactRepository;
import tr.gov.gib.sf901datajdbc.dao.model.Contact;
import tr.gov.gib.sf901datajdbc.dto.ContactDto;
import tr.gov.gib.sf901datajdbc.service.ContactService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public ContactServiceImpl(ContactRepository contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ContactDto> getAllContacts() {
        return StreamSupport.stream(contactRepository.findAll().spliterator(), false)
                .map(contact -> modelMapper.map(contact, ContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ContactDto> getContactById(Long id) {
        return contactRepository.findById(id)
                .map(contact -> modelMapper.map(contact, ContactDto.class));

    }

    @Override
    public ContactDto saveContact(ContactDto contactDto) {
        Contact contact = modelMapper.map(contactDto, Contact.class);
        Contact savedContact = contactRepository.save(contact);
        return modelMapper.map(savedContact, ContactDto.class);

    }

    @Override
    public ContactDto updateContact(ContactDto contactDto) {
        Contact existingContact = contactRepository.findById(contactDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Contact not found with id: " + contactDto.getId()));
        modelMapper.map(contactDto, existingContact);
        Contact savedContact = contactRepository.save(existingContact);
        return modelMapper.map(savedContact, ContactDto.class);
    }


    @Override
    public void deleteContact(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new IllegalArgumentException("Contact not found with id: " + id);
        }
        contactRepository.deleteById(id);

    }
}
