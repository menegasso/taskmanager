package com.example.taskmanager.application.service;

import com.example.taskmanager.application.dto.TaskDTO;
import com.example.taskmanager.domain.entity.TaskEntity;
import com.example.taskmanager.domain.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDTO createTask(TaskDTO dto) {
        TaskEntity task = new TaskEntity(UUID.randomUUID(), dto.getTitle(), dto.getDescription(), false);
        TaskEntity savedTask = taskRepository.save(task);
        return convertToDTO(savedTask);
    }

    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public TaskDTO updateTask(UUID uuid, TaskDTO dto) {
        TaskEntity task = taskRepository.findByUuid(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        TaskEntity updatedTask = taskRepository.save(task);
        return convertToDTO(updatedTask);
    }

    public void deleteTask(UUID uuid) {
        taskRepository.deleteById(uuid);
    }

    private TaskDTO convertToDTO(TaskEntity task) {
        TaskDTO dto = new TaskDTO();
        dto.setUuid(task.getUuid());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.isCompleted());
        return dto;
    }

}
