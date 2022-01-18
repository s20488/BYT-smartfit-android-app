package com.example.smartfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.smartfit.Exercises.ExercisesActivity;

public class ChooseActivity extends AppCompatActivity {

    Button btnChooseExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_window);

        btnChooseExercises = findViewById(R.id.btn_choose_exercises);

        btnChooseExercises.setOnClickListener(v -> showChooseExercises());
    }

    private void showChooseExercises() {
        startActivity(new Intent(this, ExercisesActivity.class));
    }
}