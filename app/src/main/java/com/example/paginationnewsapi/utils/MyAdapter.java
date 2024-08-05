package com.example.paginationnewsapi.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paginationnewsapi.R;
import com.example.paginationnewsapi.model.Article;
import com.example.paginationnewsapi.model.ListNewsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends PagedListAdapter<Article,MyViewHolder> {

    // DiffUtil для порівняння елементів списку
    private static final DiffUtil.ItemCallback<Article> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Article>() {
                @Override
                public boolean areItemsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
                    return oldItem.getTitle().equals(newItem.getTitle());
                }

                @Override
                public boolean areContentsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
                    // Порівняння за вмістом
                    return oldItem.getDescription().equals(newItem.getDescription());
                }
            };
    public MyAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.author.setText(getItem(position).getAuthor());
        holder.description.setText(getItem(position).getDescription());
        holder.title.setText(getItem(position).getTitle());
        Picasso.get()
                .load(getItem(position).getUrlToImage())
                .into(holder.imageView);

    }


}
