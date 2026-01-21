package com.rudxkush.taskManager.entities;

import lombok.Data;

import java.util.*;

@Data
public class TaskEntity {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private Boolean completed;
}
