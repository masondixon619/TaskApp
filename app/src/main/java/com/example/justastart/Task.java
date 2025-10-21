package com.example.justastart;

import java.io.Serializable;

// Implement Serializable to allow the object to be passed between activities
public class Task implements Serializable {

    private String title;
    private String description;

    // Constructor
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
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
}