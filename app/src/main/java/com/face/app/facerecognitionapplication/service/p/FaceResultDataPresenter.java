package com.face.app.facerecognitionapplication.service.p;

import android.content.Context;
import android.content.Intent;

import com.face.app.facerecognitionapplication.service.m.DataManager;
import com.face.app.facerecognitionapplication.service.v.FaceResultDataView;
import com.face.app.facerecognitionapplication.service.v.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * P层请求
 *
 * @author Leo
 * @time 2018/6/22 10:06
 */

public class FaceResultDataPresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private FaceResultDataView mDataView;
    private Object mData;

    public FaceResultDataPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onCreate() {
        manager = new DataManager(mContext);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        mDataView = (FaceResultDataView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intetn) {
    }

    /**
     * 请求数据
     *
     * @param type 类型
     */
    public void getSearchDatas(String type) {
        mCompositeSubscription.add(manager.getDatas(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {
                        if (mData != null) {
                            mDataView.onSuccess(mData);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mDataView.onError("数据请求失败！");
                    }

                    @Override
                    public void onNext(Object data) {
                        mData = data;
                    }
                })
        );
    }
}
