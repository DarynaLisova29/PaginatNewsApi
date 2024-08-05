package com.example.paginationnewsapi.source;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.paginationnewsapi.App;
import com.example.paginationnewsapi.model.Article;
import com.example.paginationnewsapi.model.ListNewsModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewsDataSource extends PageKeyedDataSource<Integer, Article>{


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Article> callback) {
        Observable<ListNewsModel>observable= App.getNews()
                .getData(App.q,"2024-08-04",App.sortBy,App.KEY,1,5);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListNewsModel>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull ListNewsModel listNewsModel) {
                        List<Article>articlesList=listNewsModel.getArticles();

                        callback.onResult(articlesList,null,2);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Article> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Article> callback) {
        Observable<ListNewsModel>observable= App.getNews()
                .getData(App.q,"2024-08-04",App.sortBy,App.KEY,1,5);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListNewsModel>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull ListNewsModel listNewsModel) {
                        List<Article>articlesList=listNewsModel.getArticles();

                        callback.onResult(articlesList, params.key+1);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
