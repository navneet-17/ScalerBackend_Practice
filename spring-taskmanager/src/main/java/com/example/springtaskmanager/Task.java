package com.example.springtaskmanager;

import java.util.Date;

public class Task {

    Integer id;
    String title;
    String description;
    Date dueDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Task(int id, String title, String description, Date dueDate) {
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDuedate(Date duedate) {
        this.dueDate = duedate;
    }
}
