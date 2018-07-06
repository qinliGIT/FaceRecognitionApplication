package com.face.app.facerecognitionapplication.view.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Name: BaseActivity
 * Author: Leo
 * Comment: //TODO
 * Date: 2018/7/5 14:12
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatesBar();
    }

    private void initStatesBar() {
        //设置noTitle
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//设置android 4.4以上即api19以上的状态栏为半透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
//将我们自己的toolbar替换掉actionbar,最好让activity的theme是noActionbar的
    }


}
