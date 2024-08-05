package com.example.paginationnewsapi;

import android.app.Application;

import com.example.paginationnewsapi.api.NewsApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private Retrofit retrofit;
    public static NewsApi newsApi;
    private static String URL="https://newsapi.org/";
    public static String KEY="af12a671ad0a40fab5e4236bb1743f9b";
    public static String q="Apple";
    public static String sortBy="popularity";

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        newsApi=retrofit.create(NewsApi.class);
    }
    public static NewsApi getNews(){
        return newsApi;
    }
}
