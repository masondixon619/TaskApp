package com.example.justastart;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void newTask(View v){
        View taskBox = findViewById(R.id.PTask);
        taskBox.setVisibility(VISIBLE);

        View taskButton = findViewById(R.id.BTask);
        taskButton.setVisibility(INVISIBLE);

        View mapButton = findViewById(R.id.BMap);
        mapButton.setVisibility(INVISIBLE);

        View welcomeText = findViewById(R.id.TWelcome);
        welcomeText.setVisibility(INVISIBLE);

    }
}