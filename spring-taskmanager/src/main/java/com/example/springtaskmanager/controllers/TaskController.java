package com.example.springtaskmanager.controllers;
import com.example.springtaskmanager.dtos.ErrorResponse;
import com.example.springtaskmanager.entities.Task;
import com.example.springtaskmanager.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class TaskController {
    private TasksService tasksService;

    public TaskController(@Autowired TasksService tasksService) {
        this.tasksService = tasksService;
    }
        /* Show all existing tasks*/
        @GetMapping("/tasks")
        ResponseEntity< List<Task> > getTasks() {
            return ResponseEntity.ok(tasksService.getTask());
        }

        /* Create a new task*/
        @PostMapping("/tasks")
        ResponseEntity<Task> createTask(@RequestBody Task task) {
            var newTask = tasksService.createTask(task.getTitle(), task.getDescription(), task.getDueDate());
            return ResponseEntity.created(URI.create("/tasks/"+newTask.getId())).body(newTask);
        }

        /* Get a task by id */
        @GetMapping("/tasks/{id}")
        ResponseEntity<Task> getTask(@PathVariable("id") Integer id) {
            // TODO: Implement this method
            return ResponseEntity.ok(tasksService.getTaskById(id));
            // TODO: BONUS: Return 404 if task not found
        }

        /*Delete a task by given id*/
        @DeleteMapping("/tasks/{id}")
        ResponseEntity<Task> deleteTask(@PathVariable("id") Integer id) {
            return ResponseEntity.accepted().body(tasksService.deleteTask(id));
            // TODO: BONUS: Return 404 if task not found
        }

        /**
         * Update a task by given id */
        @PatchMapping("/tasks/{id}")
        ResponseEntity<Task>  updateTask(@PathVariable("id") Integer id, @RequestBody Task task) {
             var updatedTask= tasksService.updateTask(id, task.getTitle(), task.getDescription(), task.getDueDate());
            return ResponseEntity.accepted().body(updatedTask);
        }
        //Error handling
    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    ResponseEntity<ErrorResponse> handleErrors(TasksService.TaskNotFoundException ex){
//            return ResponseEntity.notFound().build();
            return new ResponseEntity<>(
                    new ErrorResponse("Task not found", ex.getMessage()),
                    HttpStatus.NOT_FOUND);
    }
}



