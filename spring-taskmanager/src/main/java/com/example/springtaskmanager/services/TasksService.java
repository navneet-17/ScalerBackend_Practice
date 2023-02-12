package com.example.springtaskmanager.services;

import com.example.springtaskmanager.entities.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TasksService {
    private final List<Task> taskList;
    private AtomicInteger taskId = new AtomicInteger(0);

    public static class TaskNotFoundException extends IllegalArgumentException{
        public TaskNotFoundException (Integer id){
            super("Task with ID "+id+" is not found!");
        }
    }

    public TasksService() {
        taskList = new ArrayList<>();
        taskList.add(new Task(taskId.incrementAndGet(), "Task 1", "Description 1",  "2021-01-01"));
        taskList.add(new Task(taskId.incrementAndGet(), "Task 2", "Description 2",  "2021-01-01"));
        taskList.add(new Task(taskId.incrementAndGet(), "Task 3", "Description 3",  "2021-01-01"));
    }

    // return the list of available tasks.
    public List<Task> getTask(){
        return taskList;
    }

    // create a new task using the info passed as arguments.
    public Task createTask(String title,String description,String dueDate){
        var newTask = new Task(taskId.incrementAndGet(), title, description, dueDate);
        taskList.add(newTask);
        return newTask;
    }

    // fetch a task using the task Id.
    public Task getTaskById(Integer id) {
        for(Task t1: taskList)
        {
            if(t1.getId()==id)
                return t1;
        }
        // TODO: BONUS: Return 404 if task not found
       throw new TaskNotFoundException(id);
//        return taskList.stream()
//                .filter(task -> task.getId().equals(id)).findFirst()
//                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    // Update an existing task.
    public Task updateTask(Integer id, String title, String description, String dueDate){
        var task = getTaskById(id); // the exception will be thrown here itself if a task id is not found.
        if (title != null) task.setTitle(title);
        if (description != null) task.setDescription(description);
        if (dueDate != null) task.setDueDate(dueDate);
        return task;
    }

    // Delete an existing task.
    public Task deleteTask(Integer id) {
        var task = getTaskById(id); // the exception will be thrown here itself if a task id is not found.
        taskList.remove(task);
        return task;
    }

}
