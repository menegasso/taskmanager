package com.example.taskmanager.infrastructure.repository;

import com.example.taskmanager.domain.entity.TaskEntity;
import com.example.taskmanager.domain.repository.TaskRepository;
import com.example.taskmanager.infrastructure.entity.TaskJpaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final SpringTaskRepository springTaskRepository;

    public TaskRepositoryImpl(SpringTaskRepository springTaskRepository) {
        this.springTaskRepository = springTaskRepository;
    }

    private TaskEntity toDomain(TaskJpaEntity taskJpaEntity) {
        return new TaskEntity(
                taskJpaEntity.getUuid(),
                taskJpaEntity.getTitle(),
                taskJpaEntity.getDescription(),
                taskJpaEntity.isCompleted()
        );
    }

    private TaskJpaEntity toJpa(TaskEntity taskEntity) {
        TaskJpaEntity taskJpaEntity = new TaskJpaEntity();
        taskJpaEntity.setUuid(taskEntity.getUuid());
        taskJpaEntity.setTitle(taskEntity.getTitle());
        taskJpaEntity.setDescription(taskEntity.getDescription());
        taskJpaEntity.setCompleted(taskEntity.isCompleted());
        return taskJpaEntity;
    }

    @Override
    public TaskEntity save(TaskEntity task) {
        TaskJpaEntity taskJpaEntity = toJpa(task);
        TaskJpaEntity savedTaskJpaEntity = springTaskRepository.save(taskJpaEntity);
        return toDomain(savedTaskJpaEntity);
    }

    @Override
    public List<TaskEntity> findAll() {
        return springTaskRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TaskEntity> findByUuid(UUID uuid) {
        return springTaskRepository.findById(uuid).map(this::toDomain);
    }

    @Override
    public void deleteById(UUID uuid) {
        springTaskRepository.deleteById(uuid);
    }
}
