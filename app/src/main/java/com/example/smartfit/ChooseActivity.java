package com.example.smartfit;

import static com.example.smartfit.kalendarz.CalendarUtils.daysInMonthArray;
import static com.example.smartfit.kalendarz.CalendarUtils.monthYearFromDate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartfit.Exercises.ExercisesActivity;
import com.example.smartfit.kalendarz.CalendarAdapter;
import com.example.smartfit.kalendarz.CalendarUtils;
import com.example.smartfit.kalendarz.WeekViewActivity;
import com.example.smartfit.kalkulator.Calculator;
import com.example.smartfit.kalkulator.Settings;



import java.time.LocalDate;
import java.util.ArrayList;

public class ChooseActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener {

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;

    Button btnChooseExercises;
    Button btnChooseCalculator;
    Button Settings;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_window);

        btnChooseCalculator=findViewById(R.id.btn_choose_calculator);
        btnChooseCalculator.setOnClickListener(v -> showKalkulator());

        btnChooseExercises = findViewById(R.id.btn_choose_exercises);

        btnChooseExercises.setOnClickListener(v -> showChooseExercises());

        Settings=findViewById(R.id.choose_settings);
        Settings.setOnClickListener(v -> showSettings());


        initWidgets();
        CalendarUtils.selectedDate = LocalDate.now();
        setMonthView();
    }

    private void showChooseExercises() {
        startActivity(new Intent(this, ExercisesActivity.class));
    }
    private void showKalkulator() { startActivity(new Intent(this, Calculator.class)); }
    private void showSettings() { startActivity(new Intent(this, Settings.class)); }
    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setMonthView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, (CalendarAdapter.OnItemListener) this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void previousMonthAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1);
        setMonthView();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void nextMonthAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1);
        setMonthView();
    }

    public void weeklyAction(View view)
    {
        startActivity(new Intent(this, WeekViewActivity.class));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(int position, LocalDate date)
    {
        if(date != null)
        {
            CalendarUtils.selectedDate = date;
            setMonthView();
        }
    }
}