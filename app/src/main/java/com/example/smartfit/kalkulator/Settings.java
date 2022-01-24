package com.example.smartfit.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.CompoundButton;

import com.example.smartfit.R;

public class Settings extends AppCompatActivity {

    SwitchCompat switchCombat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
    setTheme(R.style.Theme_Dark);
}else
{
    setTheme(R.style.Theme_Light);
}

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        switchCombat = findViewById(R.id.bt_switch);
        switchCombat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}