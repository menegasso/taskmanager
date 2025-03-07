package com.example.taskmanager.interfaces.rest;

import com.example.taskmanager.application.dto.TaskDTO;
import com.example.taskmanager.application.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Criação de uma nova tarefa
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO createdTask = taskService.createTask(taskDTO);
        return ResponseEntity.ok(createdTask);
    }

    // Retorna todas as tarefas
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // Atualiza uma tarefa existente, identificada pelo UUID
    @PutMapping("/{uuid}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable UUID uuid, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTask(uuid, taskDTO);
        return ResponseEntity.ok(updatedTask);
    }

    // Exclui uma tarefa pelo UUID
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID uuid) {
        taskService.deleteTask(uuid);
        return ResponseEntity.noContent().build();
    }
}
