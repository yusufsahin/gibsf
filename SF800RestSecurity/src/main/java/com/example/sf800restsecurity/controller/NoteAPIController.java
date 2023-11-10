package com.example.sf800restsecurity.controller;


import com.example.sf800restsecurity.dao.model.Note;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/notes")

public class NoteAPIController {
    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        List<Note> data = new ArrayList<>();
        Note note1= new Note(1L,"Note 1","Note Desc 1");
        Note note2= new Note(2L,"Note 2","Note Desc 2");
        Note note3= new Note(3L,"Note 3","Note Desc 3");
        data.add(note1);
        data.add(note2);
        data.add(note3);
        return ResponseEntity.ok(data);
    }
}
