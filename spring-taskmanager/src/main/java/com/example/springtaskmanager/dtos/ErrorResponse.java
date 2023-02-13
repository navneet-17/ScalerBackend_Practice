package com.example.springtaskmanager.dtos;

public class ErrorResponse {
    private String message;

    public ErrorResponse(String error, String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
