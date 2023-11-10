package tr.gov.gib.sf901datajdbc.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
}