package com.face.app.facerecognitionapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

/**
 * Name: ToolBar
 * Author: Leo
 * Comment: //TODO
 * Date: 2018/7/5 16:35
 */
public class ToolBar {
    private Context context;
    private static ToolBar utils;

    public static ToolBar getInstance(Context context) {
        if (utils == null) {
            synchronized (ToolBar.class) {
                if (utils == null) {
                    utils = new ToolBar(context);
                }
            }
        }
        return utils;
    }

    /**
     * @param context
     */
    private ToolBar(Context context) {
        this.context = context.getApplicationContext();
    }

    /**
     * 设置toolbar
     * @param a
     * @param toolbar
     */
    public void SetToolBar(Activity a, Toolbar toolbar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int statesBarHeight = DisplayUtil.getStatusHeight(a);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) toolbar.getLayoutParams();
            layoutParams.height += statesBarHeight;
            toolbar.setLayoutParams(layoutParams);
            toolbar.setPadding(toolbar.getPaddingLeft(),
                    toolbar.getPaddingTop() + statesBarHeight,
                    toolbar.getPaddingRight(), toolbar.getPaddingBottom());
        }
    }

}
