package com.example.taskmanager.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity(name = "tasks")
@Data
public class TaskJpaEntity {

    @Id
    private UUID uuid;
    private String title;
    private String description;
    private boolean completed;

}
