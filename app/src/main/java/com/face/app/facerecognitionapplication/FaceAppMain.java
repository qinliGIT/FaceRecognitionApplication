package com.face.app.facerecognitionapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class FaceAppMain extends AppCompatActivity {

    @InjectView(R.id.main_left_drawer_layout)
    RelativeLayout mainLeftDrawerLayout;
    @InjectView(R.id.main_drawer_layout)
    DrawerLayout mainDrawerLayout;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    private ActionBarDrawerToggle drawerbar;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_app_main);
        ButterKnife.inject(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initLayout();
        initEvent();
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLeftLayout();
            }
        });
    }


    public void initLayout() {
        mainDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        //设置菜单内容之外其他区域的背景色
        mainDrawerLayout.setScrimColor(Color.TRANSPARENT);
        //左边菜单
        mainLeftDrawerLayout = (RelativeLayout) findViewById(R.id.main_left_drawer_layout);
    }

    //设置开关监听
    private void initEvent() {
        drawerbar = new ActionBarDrawerToggle(this, mainDrawerLayout, R.mipmap.ic_launcher, R.string.app_name, R.string.title_home) {
            //菜单打开
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            // 菜单关闭
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mainDrawerLayout.addDrawerListener(drawerbar);
    }

    //左边菜单开关事件
    public void openLeftLayout() {
        if (mainDrawerLayout.isDrawerOpen(mainLeftDrawerLayout)) {
            mainDrawerLayout.closeDrawer(mainLeftDrawerLayout);
        } else {
            mainDrawerLayout.openDrawer(mainLeftDrawerLayout);
        }
    }


}
