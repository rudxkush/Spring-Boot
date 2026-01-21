package com.rudxkush.taskManager.controllers;

import com.rudxkush.taskManager.entities.TaskEntity;
import com.rudxkush.taskManager.service.TaskService;
import dto.CreateTaskDTO;
import dto.ErrorResponseDTO;
import dto.UpdateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.math.*;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TaskService taskService;
    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks() {
        var  tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id) {
        var tasks = taskService.getTaskById(id);
        if(tasks == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) throws ParseException {
        var task = taskService.addTask(body.getTitle(), body.getDescription(), String.valueOf(deadlineFormatter.parse(body.getDeadline())));
        return ResponseEntity.ok(task);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception e) {
        if(e instanceof ParseException)
            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid Date Format"));
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal Server Error"));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO body) throws ParseException {
        var task = taskService.updateTask(id, body.getDescription(), body.getDeadline(), body.getCompleted());
        if(task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }
}
