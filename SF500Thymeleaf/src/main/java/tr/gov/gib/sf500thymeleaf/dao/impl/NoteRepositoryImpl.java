package tr.gov.gib.sf500thymeleaf.dao.impl;

import org.springframework.stereotype.Repository;
import tr.gov.gib.sf500thymeleaf.dao.NoteRepository;
import tr.gov.gib.sf500thymeleaf.dao.model.Note;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NoteRepositoryImpl implements NoteRepository {
    private  Long idCounter=1L;
    private  List<Note> notes= new ArrayList<>();

    @Override
    public List<Note> findAll() {
        return notes;
    }

    @Override
    public Note findById(Long id) {
        return notes.stream().filter(note-> note.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Note note) {
        if(note.getId()==null){
            note.setId(idCounter++);
        }
        notes.add(note);

    }

    @Override
    public void update(Note note) {
        Note existingNote= findById(note.getId());
        if(existingNote!=null){
            existingNote.setName(note.getName());
            existingNote.setDescription(note.getDescription());
        }
    }

    @Override
    public void deleteById(Long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }

    @Override
    public void saveAll(List<Note> list) {
        for (Note note:list){
            if(note.getId()==null){
                note.setId(idCounter++);
            }
        }
        notes.addAll(list);
    }
}
