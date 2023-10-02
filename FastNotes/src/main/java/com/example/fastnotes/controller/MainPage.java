package com.example.fastnotes.controller;

import com.example.fastnotes.model.NoteField;
import com.example.fastnotes.service.NotesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.UUID;

@Controller
public class MainPage {
    private final NotesService notesService;

    public MainPage(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/")
    public String MainPage(){
        return "mainpage";
    }


    @GetMapping("/showNote/{noteId}")
    public String showNote(
            @PathVariable("noteId")
            UUID noteId,
            Model model) {

        NoteField note = notesService.getText(noteId.toString());
        if (note != null) {
            model.addAttribute("text", note.getText());
            notesService.deleteField(note);
        } else {
            model.addAttribute("text",
                    "Нет запрошенной ссылки");
        }

       // model.addAttribute("textNote", textNote);
        return "/showNote";
    }


    @GetMapping("/newlink/{id}")
    public String ShowLink(
            @PathVariable("id")
            Long id,
            Model model) {


        String uuidString =
                "http://localhost:8080/showNote/" +
                        notesService.getById(id)
                                .get()
                                .getMessageId()
                                .toString();

        model.addAttribute("uuidString",uuidString);

        return "newlink";
    }

    // PATHVARIABLE
    @PostMapping("/")
    public String GetNoteField(
            @ModelAttribute("NoteField")
            NoteField field){

        UUID uuid = notesService.addNote(field);
        String redirect= "redirect:/newlink/" + field.getId().toString();
        System.out.println(field.getId().toString());
        return redirect;
    }
}
