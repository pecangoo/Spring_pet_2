package com.example.fastnotes.service;


import com.example.fastnotes.model.NoteField;
import com.example.fastnotes.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class NotesService {
    private final NotesRepository notesRepository;
    NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public UUID addNote(NoteField noteField) {
        UUID uuid = UUID.randomUUID();
        noteField.setMessageId(uuid);
        notesRepository.save(noteField);
        return uuid;
    }

    public Optional<NoteField> getById(Long id){
        return notesRepository.findById(id);
    }

    public NoteField getText(String uuidString) {
        return notesRepository.getByMessageId(UUID.fromString(uuidString));
    }

    public void  deleteField(NoteField note) {
        notesRepository.delete(note);
    }

}
