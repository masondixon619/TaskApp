package com.example.justastart;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// Implement Serializable to allow the object to be passed between activities
public class Task implements Serializable {
    private String title;
    private String description;
    private boolean recurring;
    private long dueDateMillis;
    private long creationDate;
    private long completionDate;
    private boolean isCompleted;



    // Constructor
    public Task(String title, String description, boolean recurring, long dueDateMillis
                , long creationDate, long completionDate) {
        this.title = title;
        this.description = description;
        this.recurring = recurring;
        this.dueDateMillis = dueDateMillis;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
        this.isCompleted = false;
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

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public long getDueDateMillis() {
        return dueDateMillis;
    }

    public void setDueDateMillis(long dueDateMillis) {
        this.dueDateMillis = dueDateMillis;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(long completionDate) {
        this.completionDate = completionDate;
    }


    public boolean isOverdue() {
        if (isCompleted || dueDateMillis == 0) {
            return false;
        }
        // Get the start of today in milliseconds
        Calendar calToday = Calendar.getInstance();
        calToday.set(Calendar.HOUR_OF_DAY, 0);
        // ... (reset other fields) ...
        long todayMillis = calToday.getTimeInMillis();

        // Simple and fast comparison!
        return dueDateMillis < todayMillis;
    }

    public String getFormattedDueDate(String format) {
        if (dueDateMillis == 0) {
            return ""; // Return empty if no date is set
        }
        // Create a Date object from the milliseconds
        Date date = new Date(dueDateMillis);
        // Create a formatter with the specified format
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        // Return the formatted string
        return sdf.format(date);
    }

    public static String getFormattedDate(long dateMillis, String format) {
        if (dateMillis == 0){
            return "";
        }
        Date date = new Date(dateMillis);
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        return sdf.format(date);

        }
}