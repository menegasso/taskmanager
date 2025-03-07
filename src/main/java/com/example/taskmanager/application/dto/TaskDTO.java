package com.example.taskmanager.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TaskDTO {

    private UUID uuid;
    private String title;
    private String description;
    private boolean completed;

}
