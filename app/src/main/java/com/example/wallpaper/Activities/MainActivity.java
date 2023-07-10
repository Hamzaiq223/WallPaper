package com.example.wallpaper.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.wallpaper.Adapter.NaturalImageAdapter;
import com.example.wallpaper.Models.NaturalImages;
import com.example.wallpaper.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvNaturalImages;
    NaturalImageAdapter naturalImageAdapter;
    ArrayList<NaturalImages> images;

    StorageReference storageRef;

    StorageReference imagesRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storageRef = FirebaseStorage.getInstance().getReference();
        imagesRef = storageRef.child("Nature");

        rvNaturalImages = findViewById(R.id.rvNaturalImages);
        images  = new ArrayList<>();
        naturalImageAdapter = new NaturalImageAdapter(this,images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rvNaturalImages.setLayoutManager(gridLayoutManager);
        rvNaturalImages.setAdapter(naturalImageAdapter);

        retrieveImageUrls();
    }
    private void retrieveImageUrls() {


        // List all items under "images" folder
        imagesRef.listAll().addOnSuccessListener(listResult -> {
            for (StorageReference item : listResult.getItems()) {
                // Get the download URL for each item
                item.getDownloadUrl().addOnSuccessListener(uri -> {
                    String imageUrl = uri.toString();
                    images.add(new NaturalImages(imageUrl));
                    naturalImageAdapter.notifyDataSetChanged();
                }).addOnFailureListener(e -> {
                    // Handle any errors while retrieving the download URL
                });
            }
        }).addOnFailureListener(e -> {
            // Handle any errors while listing the items
        });
    }
}