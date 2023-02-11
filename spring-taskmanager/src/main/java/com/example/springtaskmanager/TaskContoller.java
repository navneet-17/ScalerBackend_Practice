package com.example.springtaskmanager;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TaskContoller {
   private final List<Task> taskList;
    private AtomicInteger taskId = new AtomicInteger(0);

    public TaskContoller() {
        this.taskList = new ArrayList<>();
        taskList.add(new Task(taskId.incrementAndGet(), "Task 1", "Description 1", new Date()));
        taskList.add(new Task(taskId.incrementAndGet(), "Task 2", "Description 2", new Date()));
        taskList.add(new Task(taskId.incrementAndGet(), "Task 3", "Description 3", new Date()));

    }
        /**
         * Show all existing tasks
         * GET /tasks
         * @return List of tasks
         */
        @GetMapping("/tasks")
        List<Task> getTasks() {
            return taskList;
        }

        /**
         * Create a new task
         * POST /tasks
         * Body:
         *  <pre>
         *      {
         *          "title": "Task 4",
         *          "description": "Description 4",
         *          "dueDate": "2021-01-01"
         *      }
         *  </pre>
         * @param task Task object sent by client
         * @return Task object created
         */
        @PostMapping("/tasks")
        Task createTask(@RequestBody Task task) {
            var newTask = new Task(taskId.incrementAndGet(), task.getTitle(), task.getDescription(), task.getDueDate());
            taskList.add(newTask);
            return newTask;
        }

        /**
         * Get a task by id
         * @param id
         * @return Task object
         */
        @GetMapping("/tasks/{id}")
        Task getTask(@PathVariable("id") Integer id) {
            // TODO: Implement this method
            for(Task t1: taskList)
            {
                if(t1.getId()==id)
                    return t1;
            }
            // TODO: BONUS: Return 404 if task not found
            return null; // Will have to learn how to return Error 404.
        }

        /**
         * Delete a task by given id
         * @param id Task id to delete
         * @return the deleted task
         */
        @DeleteMapping("/tasks/{id}")
        Task deleteTask(@PathVariable("id") Integer id) {
            // TODO: Implement this method
            for(Task t1: taskList)
            {
                if(t1.getId()==id){
                    taskList.remove(t1);
                    return t1;
                }
            }
            // TODO: BONUS: Return 404 if task not found
            return null; // Will have to learn how to return Error 404.
        }

        /**
         * Update a task by given id
         * @param id Task id to update
         * @param task Task object sent by client
         * @return the updated task
         */
        @PatchMapping("/tasks/{id}")
        Task updateTask(@PathVariable("id") Integer id, @RequestBody Task task) {
            // TODO: BONUS: Update the task with given id
            // Request body might have only title, description or dueDate (not necessarily all fields)
            for(Task t1: taskList)
            {
                if(t1.getId()==id){
                    //Check which attribute needs to be updated and update it.
                    if(task.title!= null && !task.title.equals(t1.getTitle()))
                        t1.setTitle(task.title);
                    if (task.description!= null && !task.description.equals(t1.getDescription()))
                        t1.setDescription(task.description);
                    if (task.dueDate != null && task.dueDate!=t1.getDueDate())
                        t1.setDuedate(task.dueDate);
                    return t1;
                }
            }
            return null;
        }
    }



