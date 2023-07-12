package com.example.wallpaper.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.wallpaper.R;

public class ViewImage extends AppCompatActivity {

    String image;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        ivImage = findViewById(R.id.ivImage);

        image = getIntent().getStringExtra("image");

        Glide.with(this)
                .load(image)
                .error(R.drawable.ic_launcher_background)
                .into(ivImage);
    }
}