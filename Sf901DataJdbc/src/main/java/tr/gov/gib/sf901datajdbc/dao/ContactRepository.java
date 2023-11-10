package tr.gov.gib.sf901datajdbc.dao;

import org.springframework.data.repository.CrudRepository;
import tr.gov.gib.sf901datajdbc.dao.model.Contact;

public interface ContactRepository  extends CrudRepository<Contact,Long> {
}
