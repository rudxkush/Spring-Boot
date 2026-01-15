package com.rudxkush.taskManager.service;

import com.rudxkush.taskManager.entities.TaskEntity;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;

@Repository
public class TaskService {
    @Getter
    private ArrayList<TaskEntity> tasks= new ArrayList<>();
    private int taskId = 1;

    public TaskEntity addTask(String title, String description, String deadline) {
        TaskEntity task  = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
//        task.setDeadline(new Date(deadline));  // TODO : Validate Date Format
        task.setCompleted(false);
        tasks.add(task);
        taskId += 1;
        return task;
    }

    public TaskEntity getTaskById(int id) {
        for(TaskEntity task : tasks) {
            if(task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
