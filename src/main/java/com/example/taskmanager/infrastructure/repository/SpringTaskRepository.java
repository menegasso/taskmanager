package com.example.taskmanager.infrastructure.repository;

import com.example.taskmanager.infrastructure.entity.TaskJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringTaskRepository extends JpaRepository<TaskJpaEntity, UUID> {
}
