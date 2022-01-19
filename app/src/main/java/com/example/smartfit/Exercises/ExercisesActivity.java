package com.example.smartfit.Exercises;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.smartfit.R;
import com.example.smartfit.Exercises.adapter.ProductAdapter;
import com.example.smartfit.Exercises.model.model;

import java.util.ArrayList;
import java.util.List;

public class ExercisesActivity extends AppCompatActivity {

    RecyclerView prodItemRecycler1;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.cr1, "Feat And Beat", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cr2, "Workouts At Home", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cr3, "Anytime Anywhere", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels);

        List<model> productsList = new ArrayList<>();
        productsList.add(new model(1, "MOUNTAIN CLIMBERS", "Time : 2 min", R.drawable.exersice_1));
        productsList.add(new model(2, "BASIC CRUNCH", "Time : 2 min", R.drawable.exersice_2));
        productsList.add(new model(3, "REVERSE PUSHUPS", "Time : 2 min", R.drawable.exersice_3));
        productsList.add(new model(4, "BICYCLE", "Time : 2 min", R.drawable.exersice_4));
        productsList.add(new model(5, "FLAT BENCH LYING LEG RAISE", "Time : 2 min", R.drawable.exersice_5));
        productsList.add(new model(6, "HEEL TOUCH", "Time : 2 min", R.drawable.exersice_6));
        productsList.add(new model(7, "KNEES TO ELBOWS", "Time : 2 min", R.drawable.exersice_7));
        productsList.add(new model(8, "ALT ARM LEG RAISES", "Time : 2 min", R.drawable.exersice_9));
        productsList.add(new model(9, "PLANK WITH ARM RAISE", "Time : 2 min", R.drawable.exersice_10));
        productsList.add(new model(10, "PLANK WITH LEG", "Time : 2 min", R.drawable.exersice_11));
        productsList.add(new model(11, "SEATED OBLIQUE TWISTS", "Time : 2 min", R.drawable.exersice_12));
        productsList.add(new model(12, "GLUTE BRIDGES", "Time : 2 min", R.drawable.exersice_13));
        productsList.add(new model(13, "SCISSOR KICK", "Time : 2 min", R.drawable.exersice_14));
        productsList.add(new model(14, "WINDMILL", "Time : 2 min", R.drawable.exersice_15));

        setProdItemRecycler1(productsList);
    }

    private void setProdItemRecycler1(List<model> productsList){
        prodItemRecycler1 = findViewById(R.id.recview1);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        prodItemRecycler1.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler1.setAdapter(productAdapter);
    }
}