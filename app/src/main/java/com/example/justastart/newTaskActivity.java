package com.example.justastart;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// 1. Implement the OnDateSetListener interface
public class newTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText taskNameInput;
    private EditText taskDescriptionInput;
    private EditText editTextDate; // 2. Add member variable for the date EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        // Initialize all your views from the layout
        taskNameInput = findViewById(R.id.taskNameInput);
        taskDescriptionInput = findViewById(R.id.taskDescriptionInput);
        editTextDate = findViewById(R.id.editTextDate); // Find the date EditText
    }

    // 3. This method is called when the date EditText is clicked (due to android:onClick)
    public void showDatePickerDialog(View v) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this, // The listener to call when a date is set
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    // 4. This method is called when the user selects a date in the dialog
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // Create a Calendar object to hold the selected date
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        // Define the desired date format
        String format = "MM/dd/yy"; // e.g., "10/21/25"
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);

        // Set the formatted date string to the EditText
        editTextDate.setText(sdf.format(calendar.getTime()));
    }

    // This is the onClick handler for your "Add Task" button
    public void createTask(View v) {
        // You can now get the date text just like the others
        String taskName = taskNameInput.getText().toString();
        String description = taskDescriptionInput.getText().toString();
        String date = editTextDate.getText().toString();

        // (Your logic to save the task would go here)

        // For now, let's just go back to the main activity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void cancelTask(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
}
