package com.example.paginationnewsapi.source;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.example.paginationnewsapi.model.Article;

public class NewsDataSourceFactory extends DataSource.Factory<Integer, Article> {
    @NonNull
    @Override
    public DataSource<Integer, Article> create() {
        return new NewsDataSource();
    }
}
