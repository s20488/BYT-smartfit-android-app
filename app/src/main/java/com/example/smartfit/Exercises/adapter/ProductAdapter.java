package com.example.smartfit.Exercises.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartfit.Exercises.ElevenExercise;
import com.example.smartfit.Exercises.FifteenExercise;
import com.example.smartfit.Exercises.FirstExercise;
import com.example.smartfit.Exercises.FiveExercise;
import com.example.smartfit.Exercises.FourExercise;
import com.example.smartfit.Exercises.FourteenExercise;
import com.example.smartfit.Exercises.NineExercise;
import com.example.smartfit.Exercises.SecondaryExercise;
import com.example.smartfit.Exercises.SevenExercise;
import com.example.smartfit.Exercises.SixExercise;
import com.example.smartfit.Exercises.TenExercise;
import com.example.smartfit.Exercises.ThirdExercise;
import com.example.smartfit.Exercises.ThirteenExercise;
import com.example.smartfit.Exercises.TwelveExercise;
import com.example.smartfit.R;
import com.example.smartfit.Exercises.model.model;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    List<model> productsList;

    public ProductAdapter(Context context, List<model> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.singlerow, parent, false);
        return new ProductAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdapter.ProductViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.prodImage.setImageResource(productsList.get(position).getImageUrl());
        holder.prodName.setText(productsList.get(position).getProductName());
        holder.prodPrice.setText(productsList.get(position).getProductPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                if (position == 0) {
                    Intent i = new Intent(context, FirstExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 1) {
                    Intent i = new Intent(context, SecondaryExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 2) {
                    Intent i = new Intent(context, ThirdExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 3) {
                    Intent i = new Intent(context, FourExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 4) {
                    Intent i = new Intent(context, FiveExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 5) {
                    Intent i = new Intent(context, SixExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 6) {
                    Intent i = new Intent(context, SevenExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 7) {
                    Intent i = new Intent(context, NineExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 8) {
                    Intent i = new Intent(context, TenExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 9) {
                    Intent i = new Intent(context, ElevenExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 10) {
                    Intent i = new Intent(context, TwelveExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 11) {
                    Intent i = new Intent(context, ThirteenExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 12) {
                    Intent i = new Intent(context, FourteenExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }

                if (position == 13) {
                    Intent i = new Intent(context, FifteenExercise.class);
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                    context.startActivity(i, activityOptions.toBundle());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView prodImage;
        TextView prodName, prodPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            prodImage = itemView.findViewById(R.id.img1);
            prodName = itemView.findViewById(R.id.nametext);
            prodPrice = itemView.findViewById(R.id.desctext);
        }
    }
}
