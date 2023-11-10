package tr.gov.gib.sf901datajdbc.service;

import tr.gov.gib.sf901datajdbc.dto.ContactDto;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<ContactDto> getAllContacts();
    Optional<ContactDto> getContactById(Long id);
    ContactDto saveContact(ContactDto contactDto);

    ContactDto updateContact(ContactDto contactDto);

    void deleteContact(Long id);
}
