package com.example.wallpaper.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wallpaper.Activities.ViewImage;
import com.example.wallpaper.Models.NaturalImages;
import com.example.wallpaper.R;

import java.util.List;

public class NaturalImageAdapter extends RecyclerView.Adapter<NaturalImageAdapter.ViewHolder> {
    private List<NaturalImages> data;
    Context context;
    public NaturalImageAdapter(Context context,List<NaturalImages> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create a new ViewHolder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_natural_images, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind the data to the views in each item
        String item = data.get(position).getImageUrl();

        Glide.with(context)
                .load(item)
                .error(R.drawable.ic_launcher_background)
                .into(holder.ivImages);

        holder.ivImages.setOnClickListener(view -> {
            context.startActivity(new Intent(context, ViewImage.class).putExtra("image",item));
        });
    }

    @Override
    public int getItemCount() {
        // Return the number of items in the RecyclerView
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivImages;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImages = itemView.findViewById(R.id.ivImages);
        }
    }

}
