package com.example.springtaskmanager.controllers;
import com.example.springtaskmanager.entities.Task;
import com.example.springtaskmanager.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TaskController {
    private TasksService tasksService;

    public TaskController(@Autowired TasksService tasksService) {
        this.tasksService = tasksService;
    }
        /* Show all existing tasks*/
        @GetMapping("/tasks")
        List<Task> getTasks() {
            return tasksService.getTask();
        }

        /* Create a new task*/
        @PostMapping("/tasks")
        Task createTask(@RequestBody Task task) {
            var newTask = tasksService.createTask(task.getTitle(), task.getDescription(), task.getDueDate().toString());
            return newTask;
        }

        /* Get a task by id */
        @GetMapping("/tasks/{id}")
        Task getTask(@PathVariable("id") Integer id) {
            // TODO: Implement this method
            return tasksService.getTaskById(id);
            // TODO: BONUS: Return 404 if task not found
        }

        /*Delete a task by given id*/
        @DeleteMapping("/tasks/{id}")
        Task deleteTask(@PathVariable("id") Integer id) {
            return tasksService.deleteTask(id);
            // TODO: BONUS: Return 404 if task not found
        }

        /**
         * Update a task by given id */
        @PatchMapping("/tasks/{id}")
        Task updateTask(@PathVariable("id") Integer id, @RequestBody Task task) {
             var updatedTask= tasksService.updateTask(id, task.getTitle(), task.getDescription(), task.getDueDate());
            return updatedTask;
        }
    }



