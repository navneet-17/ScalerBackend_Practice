package com.example.springtaskmanager.entities;

public class Task {

    Integer id;
    String title;
    String description;
    String dueDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Task(Integer id, String title, String description, String dueDate) {
        this.id=id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDuedate(String duedate) {
        this.dueDate = duedate;
    }
}
