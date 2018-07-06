package com.face.app.facerecognitionapplication.service.v;

/**
 * @author Leo
 * @time 2018/6/22 10:05
 */

public interface FaceResultDataView extends View {
    void onSuccess(Object mData);

    void onError(String result);
}
