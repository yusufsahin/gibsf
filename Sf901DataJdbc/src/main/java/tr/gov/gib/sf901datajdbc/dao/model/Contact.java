package tr.gov.gib.sf901datajdbc.dao.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("contacts")
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
}