package tr.gov.gib.sf500thymeleaf.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private Long id;
    private  String name;
    private  String description;
}
