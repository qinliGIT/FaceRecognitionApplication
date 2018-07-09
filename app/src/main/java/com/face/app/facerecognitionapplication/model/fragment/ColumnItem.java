package com.face.app.facerecognitionapplication.model.fragment;

import java.io.Serializable;

/**
 * Name: ColumnItem
 * Author: Leo
 * Comment: //TODO 工具item
 * Date: 2018/7/9 11:49
 */
public class ColumnItem implements Serializable {
    private int resId;
    private String textStr;

    public ColumnItem() {
    }

    public ColumnItem(int resId, String textStr) {
        this.resId = resId;
        this.textStr = textStr;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTextStr() {
        return textStr;
    }

    public void setTextStr(String textStr) {
        this.textStr = textStr;
    }
}
