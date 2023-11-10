package com.example.sf903datajpa.service;

import com.example.sf903datajpa.dto.NoteDto;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<NoteDto> getAllNotes();
    Optional<NoteDto> getNoteById(Long id);
    NoteDto saveNote(NoteDto noteDto);

    NoteDto updateNote(NoteDto noteDto);

    void deleteNote(Long id);
}
