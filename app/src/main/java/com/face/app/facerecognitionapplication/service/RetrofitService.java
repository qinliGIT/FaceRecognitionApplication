package com.face.app.facerecognitionapplication.service;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Retrofit请求
 * @author Leo
 * @time 2018/6/22 10:01
 */

public interface RetrofitService {
    @GET("newspool/topnews?qid=10027")
    Observable<Object> getFaceDatas(@Query("type") String name);
}
