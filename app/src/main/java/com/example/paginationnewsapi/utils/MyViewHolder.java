package com.example.paginationnewsapi.utils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paginationnewsapi.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView author;
    TextView description;
    ImageView imageView;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.title);
        author=itemView.findViewById(R.id.author);
        description=itemView.findViewById(R.id.description);
        imageView=itemView.findViewById(R.id.imageView);
    }
}
