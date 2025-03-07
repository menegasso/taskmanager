package com.example.taskmanager.domain.repository;

import com.example.taskmanager.domain.entity.TaskEntity;
import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {

    TaskEntity save(TaskEntity task);
    List<TaskEntity> findAll();
    Optional<TaskEntity> findByUuid(UUID uuid);
    void deleteById(UUID uuid);

}
