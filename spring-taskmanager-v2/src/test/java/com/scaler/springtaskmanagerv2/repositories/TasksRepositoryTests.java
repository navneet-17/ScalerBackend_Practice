package com.scaler.springtaskmanagerv2.repositories;

import com.scaler.springtaskmanagerv2.entities.TaskEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class TasksRepositoryTests {
    //injecting the Task Repository.
    @Autowired  TasksRepository tasksRepository;
    @Test
    public void findCompletedTasks(){
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("Test Task 1");
        task1.setDescription("Test Task Description 1");
        task1.setCompleted(true);
        TaskEntity task2 = new TaskEntity();
        task2.setTitle("Test Task 2");
        task2.setDescription("Test Task Description 2");
        task2.setCompleted(false);
        tasksRepository.save(task1);
        tasksRepository.save(task2);
        var completedTasks = tasksRepository.findAllByCompleted(true);
        var incompletedTasks = tasksRepository.findAllByCompleted(false);

        assertEquals(1,completedTasks.size());
        assertEquals(1,incompletedTasks.size());

    }
    @Test
    public void testCreateTask() {
        //create a task
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle("Test Task ");
        taskEntity.setDescription("Test Task Description");
        taskEntity.setCompleted(false);
        //save the task
        var savedTask = tasksRepository.save(taskEntity);
        assertNotNull(savedTask);
    }
    @Test
    public void readTasksWorks(){
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("Test Task 1");
        task1.setDescription("Test Task Description 1");
        task1.setCompleted(false);
        TaskEntity task2 = new TaskEntity();
        task2.setTitle("Test Task 2");
        task2.setDescription("Test Task Description 2");
        task2.setCompleted(false);
        tasksRepository.save(task1);
        tasksRepository.save(task2);
        var tasks = tasksRepository.findAll();
        assertNotNull(tasks);
        assertEquals(2,tasks.size());
    }


}
