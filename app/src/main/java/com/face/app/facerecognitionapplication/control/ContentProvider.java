package com.face.app.facerecognitionapplication.control;

import android.content.Context;
import android.content.res.TypedArray;

import com.face.app.facerecognitionapplication.R;
import com.face.app.facerecognitionapplication.model.fragment.ColumnItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: ContentProvider
 * Author: Leo
 * Comment: //TODO 数据初始化
 * Date: 2018/7/9 12:01
 */
public class ContentProvider {
    private Context c;
    private static ContentProvider utils;

    public static ContentProvider getInstance(Context c) {
        if (utils == null) {
            synchronized (ContentProvider.class) {
                if (utils == null) {
                    utils = new ContentProvider(c);
                }
            }
        }
        return utils;
    }

    /**
     * @param c
     */
    private ContentProvider(Context c) {
        this.c = c.getApplicationContext();
    }

    /**
     * 发现页--工具箱数据
     */
    public List<ColumnItem> getColumnlist() {
        List<ColumnItem> list = new ArrayList<>();
        TypedArray ar = c.getResources().obtainTypedArray(R.array.column_images);
        for (int i = 0; i < 5; i++) {
            list.add(new ColumnItem(ar.getResourceId(i, 0), c.getResources().getStringArray(
                    R.array.column_array)[i]));
        }
        ar.recycle();
        return list;
    }
}
