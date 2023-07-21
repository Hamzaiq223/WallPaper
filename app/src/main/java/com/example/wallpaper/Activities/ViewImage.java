package com.example.wallpaper.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.wallpaper.R;
import com.jsibbold.zoomage.ZoomageView;

public class ViewImage extends AppCompatActivity {

    String image;
    ImageView ivBack;

    ZoomageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        ivImage = findViewById(R.id.ivImage);
        ivBack = findViewById(R.id.ivBack);
        image = getIntent().getStringExtra("image");

        ivBack.setOnClickListener(view -> {
            onBackPressed();
        });

        Glide.with(this)
                .load(image)
                .error(R.drawable.ic_launcher_background)
                .into(ivImage);

    }

}