package com.example.taskmanager.domain.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class TaskEntity {

    private UUID uuid;
    private String title;
    private String description;
    private boolean completed;

    public TaskEntity(UUID uuid, String title, String description, boolean completed) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

}
