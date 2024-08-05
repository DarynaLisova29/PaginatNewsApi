package com.example.paginationnewsapi.api;



import com.example.paginationnewsapi.model.ListNewsModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("v2/everything")
    Observable<ListNewsModel> getData(@Query("q")String q,
                                      @Query("from")String date,
                                      @Query("sortBy")String sortBy,
                                      @Query("apiKey")String apiKey,
                                      @Query("page") int page,
                                      @Query("pageSize")int pageSize);

}
