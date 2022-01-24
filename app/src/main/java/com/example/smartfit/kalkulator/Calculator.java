package com.example.smartfit.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.smartfit.R;
import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity {

    RadioButton girl,boy,Aktywnosc1,Aktywnosc2,Aktywnosc3;

    EditText inputWeight,inputHight,inputAge;
    Button saveButton;
    private double m,w,akt,kg;
    MetricFormula metricFormula;

    TextView showResult, showBMI,showCalorie;
    private DecimalFormat TWO_DECIMAL_PLACES = new DecimalFormat(".##");
    com.example.smartfit.kalkulator.BMICategory BMICategory = new BMICategory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inputAge=findViewById(R.id.Age);
        Aktywnosc1=(RadioButton)findViewById(R.id.Aktywosc1);
        Aktywnosc2=(RadioButton)findViewById(R.id.Aktywnosc2);
        Aktywnosc3=(RadioButton)findViewById(R.id.Aktywnosc3);
        girl = (RadioButton) findViewById(R.id.radio1);
        boy = (RadioButton) findViewById(R.id.radio2);
        saveButton = findViewById(R.id.saveButton);
        inputWeight = findViewById(R.id.NumberWeight);
        inputHight = findViewById(R.id.hight);
        showResult = findViewById(R.id.showResult);
        showBMI = findViewById(R.id.showBMI);
        showCalorie=findViewById(R.id.show_calorie);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Aktywnosc1.isChecked()){
                    akt = 1.1;
                }
                else if (Aktywnosc2.isChecked()){
                    akt=1.3;
                }
                else if (Aktywnosc3.isChecked()){
                    akt=1.6;
                }


                kg = Double.parseDouble(inputWeight.getText().toString());
                if(kg<20) {
                    Snackbar.make(inputWeight,"Enter your weight correctly", Snackbar.LENGTH_SHORT).show();
                    return;
                }


                m = Double.parseDouble(inputHight.getText().toString());
                if((m<100)) {
                    Snackbar.make(inputHight,"Enter your hight correctly", Snackbar.LENGTH_SHORT).show();
                    return;
                }


                w=Double.parseDouble(inputAge.getText().toString());
                if((w<10)) {
                    Snackbar.make(inputAge,"Enter your age correctly", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                metricFormula = new MetricFormula(kg,m,w);


                if (girl.isChecked()) {
                    showCalorie.setText("KCL = "+String.valueOf(TWO_DECIMAL_PLACES.format(metricFormula.computeGKCL(metricFormula.getInputKg(),metricFormula.getInputM(),metricFormula.getInputW(),akt))));
                } else if (boy.isChecked()) {
                    showCalorie.setText("KCL = "+String.valueOf(TWO_DECIMAL_PLACES.format(metricFormula.computeMKCL(metricFormula.getInputKg(),metricFormula.getInputM(),metricFormula.getInputW(),akt))));
                }

                showBMI.setText("BMI = " + String.valueOf(TWO_DECIMAL_PLACES.format(metricFormula.computeBMI(metricFormula.getInputKg(),metricFormula.getInputM()))));
                showResult.setText(BMICategory.getCategory(metricFormula.computeBMI(metricFormula.getInputKg(),metricFormula.getInputM())));

            }
        });


    }}