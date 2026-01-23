package com.rudxkush.taskManager.controllers;

import com.rudxkush.taskManager.entities.NoteEntity;
import com.rudxkush.taskManager.service.NotesService;
import dto.CreateNoteDTO;
import dto.CreateNoteResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.io.*;
import java.math.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.System.out;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
    private NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Integer taskId) {
        var notes = notesService.getNotesForTask(taskId);
        return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNote(
            @PathVariable("taskId") Integer taskId,
            @RequestBody CreateNoteDTO body) {
        var note = notesService.addNoteForTask(taskId, body.getTitle(), body.getBody());
        return ResponseEntity.ok(new CreateNoteResponseDTO(taskId, note));
    }
}
