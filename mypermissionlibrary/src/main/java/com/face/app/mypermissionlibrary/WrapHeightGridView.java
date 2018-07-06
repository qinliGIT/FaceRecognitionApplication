package com.face.app.mypermissionlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Name: WrapHeightGridView
 * Author: Leo
 * Comment: //TODO
 * Date: 2018/7/6 13:36
 */
public class WrapHeightGridView extends GridView {

    //防止计算多次导致界面显示错误
    public boolean isOnMeasure;

    public WrapHeightGridView(Context context) {
        super(context);
    }

    public WrapHeightGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WrapHeightGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        isOnMeasure = true;
        int heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        isOnMeasure = false;
        super.onLayout(changed, l, t, r, b);
    }
}