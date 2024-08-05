package com.example.paginationnewsapi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.paginationnewsapi.model.Article;
import com.example.paginationnewsapi.source.NewsDataSourceFactory;

public class NewsViewModel extends ViewModel {
    private LiveData<PagedList<Article>>articlePagedList;

    public NewsViewModel() {
        NewsDataSourceFactory newsDataSourceFactory=new NewsDataSourceFactory();
        PagedList.Config config=new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build();
        articlePagedList=new LivePagedListBuilder<>(newsDataSourceFactory,config).build();
    }

    public LiveData<PagedList<Article>> getArticlePagedList() {
        return articlePagedList;
    }
}
