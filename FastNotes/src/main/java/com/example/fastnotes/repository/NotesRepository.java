package com.example.fastnotes.repository;

import com.example.fastnotes.model.NoteField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotesRepository extends JpaRepository<NoteField, Long> {
    public  NoteField getByMessageId(UUID messageId);

}
