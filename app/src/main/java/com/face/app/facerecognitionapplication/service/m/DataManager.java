package com.face.app.facerecognitionapplication.service.m;

import android.content.Context;

import com.face.app.facerecognitionapplication.service.RetrofitHelper;
import com.face.app.facerecognitionapplication.service.RetrofitService;

import rx.Observable;


/**
 * 数据请求
 *
 * @author Leo
 * @time 2018/6/22 10:02
 */

public class DataManager {
    private RetrofitService mRetrofitService;

    public DataManager(Context context) {
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    /**
     * 开始请求
     */
    public Observable<Object> getDatas(String type) {
        return mRetrofitService.getFaceDatas(type);
    }
}
