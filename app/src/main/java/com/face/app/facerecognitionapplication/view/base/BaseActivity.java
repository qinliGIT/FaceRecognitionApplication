package com.face.app.facerecognitionapplication.view.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Name: BaseActivity
 * Author: Leo
 * Comment: //TODO
 * Date: 2018/7/5 14:12
 */

public abstract class BaseActivity extends AppCompatActivity {

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
    }


    //初始化控件
//    public abstract void findId();

    //初始化数据
    public abstract void init();

    //通用性方法
    public void showToast(String msg) {
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T findView(@IdRes int id) {
        return (T) findViewById(id);
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T findView(View view, @IdRes int id) {
        return (T) view.findViewById(id);
    }

}
