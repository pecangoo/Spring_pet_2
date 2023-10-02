package com.example.fastnotes.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.UUID;



@Entity
@Data
@Table(name = "Notes", schema = "public")
@NoArgsConstructor
public class NoteField {

    String text;
    UUID messageId;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

}
