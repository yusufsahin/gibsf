package com.example.sf903datajpa;

import com.example.sf903datajpa.dao.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> , JpaSpecificationExecutor<Note> {
    List<Note> findAllByNameContains(String str);
}
