package com.face.app.facerecognitionapplication.service.p;


import android.content.Intent;

import com.face.app.facerecognitionapplication.service.v.View;

/**
 * P层接口
 * @author Leo
 * @time 2018/6/22 10:03
 */

public interface Presenter {
    void onCreate();

    void onStart();

    void onStop();

    void pause();

    void attachView(View view);

    void attachIncomingIntent(Intent intent);
}
