package tr.gov.gib.sf500thymeleaf.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tr.gov.gib.sf500thymeleaf.dao.NoteRepository;
import tr.gov.gib.sf500thymeleaf.dao.model.Note;

import java.util.Arrays;

@Component
@Order(1)
public class DataInitializer implements CommandLineRunner {
    private final NoteRepository noteRepository;

    public DataInitializer(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    @Override
    public void run(String... args) throws Exception {
          Note note1 = new Note(1L, "Note 1", "This is the description for Note 1");
          Note note2 = new Note(2L, "Note 2", "This is the description for Note 2");
          Note note3 = new Note(3L, "Note 3", "This is the description for Note 3");

        // Notları veritabanına kaydedelim (burada örnek olarak basit bir liste kullanıldı).
            noteRepository.saveAll(Arrays.asList(note1, note2, note3));
    }
}