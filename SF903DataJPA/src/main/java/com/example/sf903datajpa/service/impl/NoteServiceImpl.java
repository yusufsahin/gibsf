package com.example.sf903datajpa.service.impl;

import com.example.sf903datajpa.NoteRepository;
import com.example.sf903datajpa.dao.model.Note;
import com.example.sf903datajpa.dto.NoteDto;
import com.example.sf903datajpa.service.NoteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final ModelMapper modelMapper;

    public NoteServiceImpl(NoteRepository noteRepository, ModelMapper modelMapper) {
        this.noteRepository = noteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<NoteDto> getAllNotes() {
        return StreamSupport.stream(noteRepository.findAll().spliterator(), false)
                .map(note -> modelMapper.map(note, NoteDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NoteDto> getNoteById(Long id) {
        return noteRepository.findById(id)
                .map(note -> modelMapper.map(note, NoteDto.class));
    }

    @Override
    public NoteDto saveNote(NoteDto noteDto) {
        Note note = modelMapper.map(noteDto, Note.class);
        Note savedNote = noteRepository.save(note);
        return modelMapper.map(savedNote, NoteDto.class);
    }

    @Override
    public NoteDto updateNote(NoteDto noteDto) {
        Note existingNote = noteRepository.findById(noteDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Note not found with id: " + noteDto.getId()));
        modelMapper.map(noteDto, existingNote);
        Note updatedNote = noteRepository.save(existingNote);
        return modelMapper.map(updatedNote, NoteDto.class);
    }

    @Override
    public void deleteNote(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
        noteRepository.deleteById(id);
    }
}