package tr.gov.gib.sf710contactapp.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private int id;
    private String firstname;

    private String lastname;

    private  String phonenumber;

    private String email;
}
