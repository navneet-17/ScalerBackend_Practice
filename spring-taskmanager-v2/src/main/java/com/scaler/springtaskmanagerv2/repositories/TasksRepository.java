package com.scaler.springtaskmanagerv2.repositories;

import com.scaler.springtaskmanagerv2.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TaskEntity,Integer> {
    List<TaskEntity> findAllByCompleted(boolean completed);

    @Query("SELECT t FROM tasks t " +
            "WHERE t.completed = false " +
            "AND t.dueDate < CURRENT_DATE")
    List<TaskEntity> findAllOverdueTasks();

    // Fina all tiles containing a keyword:

    @Query("SELECT t FROM tasks t WHERE t.title LIKE %?1%")
    List<TaskEntity> findAllByTitle(String keyword);

    List<TaskEntity> findAllByTitleContainingIgnoreCase(String keyword);

    }
