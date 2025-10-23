package com.example.justastart;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class newTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText taskNameInput;
    private EditText taskDescriptionInput;
    private EditText editTextDate;

    private long dueDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        // Initialize all your views from the layout
        taskNameInput = findViewById(R.id.taskNameInput);
        taskDescriptionInput = findViewById(R.id.taskDescriptionInput);
        editTextDate = findViewById(R.id.editTextDate); // Find the date EditText

        // *** NEW: Set today's date in the EditText when the activity starts ***
        updateDateInView(Calendar.getInstance());
    }

    // This method is called when the date EditText is clicked
    public void showDatePickerDialog(View v) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );


        DatePicker datePicker = datePickerDialog.getDatePicker();

        // 2. Get a Calendar instance for today, but clear the time part
        Calendar today = Calendar.getInstance();
        // Set time to the beginning of the day (00:00:00)
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        // 3. Set the minimum date to the beginning of today
        datePicker.setMinDate(today.getTimeInMillis());

        datePickerDialog.show();
    }

    // This method is called when the user selects a date in the dialog
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // Create a Calendar object to hold the selected date
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        dueDate = calendar.getTimeInMillis();


        // *** UPDATED: Use the helper method to set the text ***
        updateDateInView(calendar);
    }

    // *** NEW HELPER METHOD ***
    private void updateDateInView(Calendar calendar) {
        String format = "MM/dd/yy"; // e.g., "10/21/25"
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        editTextDate.setText(sdf.format(calendar.getTime()));
    }


    public void checkBoxClick(View v) {
        RadioGroup recurringOptionsGroup = findViewById(R.id.recurringOptionsGroup);

        boolean checked = ((CheckBox) v).isChecked();
        if(checked){
            recurringOptionsGroup.setVisibility(View.VISIBLE);
        }
        else{
            recurringOptionsGroup.setVisibility(View.INVISIBLE);
        }




    }

    // This is the onClick handler for your "Add Task" button
    public void createTask(View v) {
        String taskName = taskNameInput.getText().toString();
        String description = taskDescriptionInput.getText().toString();
        long date = dueDate;


        Calendar calToday = Calendar.getInstance();
        calToday.set(Calendar.HOUR_OF_DAY, 0);
        // ... (reset other fields) ...
        long todayMillis = calToday.getTimeInMillis();



        // (Your logic to save the task would go here)
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void cancelTask(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}