package com.rudxkush.taskManager.service;

import com.rudxkush.taskManager.entities.NoteEntity;
import com.rudxkush.taskManager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesService {
    private  TaskService taskService;
    private HashMap<Integer, TaskNotesHolder> taskNotesHolders = new HashMap<>();

    public NotesService(TaskService taskService) {
        this.taskService = taskService;
    }

    class TaskNotesHolder {
        protected int nodeId = 1;
        protected ArrayList<NoteEntity> notes = new ArrayList<>();
    }

    public List<NoteEntity> getNotesForTask(int taskId) {
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null) {
            return null;
        }
        if(taskNotesHolders.get(taskId) == null) {
            taskNotesHolders.put(taskId, new TaskNotesHolder());
        }
        return taskNotesHolders.get(taskId).notes;
    }

    public NoteEntity addNoteForTask(int taskId, String title, String body) {
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null) {
            return null;
        }
        if(taskNotesHolders.get(taskId) == null) {
            taskNotesHolders.put(taskId, new TaskNotesHolder());
        }
        TaskNotesHolder taskNotesHolder = taskNotesHolders.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setId(taskNotesHolder.nodeId);
        note.setTitle(title);
        note.setBody(body);
        taskNotesHolder.notes.add(note);
        taskNotesHolder.nodeId++;
        return note;
    }
}
