package com.face.app.facerecognitionapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.face.app.facerecognitionapplication.adapter.pagemain.ViewPagerFragmentAdapter;
import com.face.app.facerecognitionapplication.adapter.pagemain.transformer.StereoPagerTransformer;
import com.face.app.facerecognitionapplication.utils.DisplayUtil;
import com.face.app.facerecognitionapplication.utils.ToolBar;
import com.face.app.facerecognitionapplication.view.base.BaseActivity;
import com.face.app.facerecognitionapplication.view.pageFirst.fragment.FragmentAge;
import com.face.app.facerecognitionapplication.view.pageFirst.fragment.FragmentBeauty;
import com.face.app.facerecognitionapplication.view.pageFirst.fragment.FragmentMore;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FaceAppMain extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.main_drawer_layout)
    DrawerLayout mainDrawerLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.navigation)
    BottomNavigationView navigation;
    @Bind(R.id.page_main_viewpager)
    ViewPager pageMainViewpager;
    @Bind(R.id.nav_view)
    NavigationView navView;

    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_app_main);
        ButterKnife.bind(this);
        init();
    }

    @Override
    public void init() {
        initLayout();
        initToolBar();
        initViewPager();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private void initViewPager() {
        pageMainViewpager.setPageTransformer(true, new StereoPagerTransformer(DisplayUtil.getScreenWidth(FaceAppMain.this)));
        List<Fragment> l = new ArrayList<>();
        l.add(new FragmentAge());
        l.add(new FragmentBeauty());
        l.add(new FragmentMore());
        pageMainViewpager.setAdapter(new ViewPagerFragmentAdapter(getSupportFragmentManager(), l));
        pageMainViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
                initStatesColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        ToolBar.getInstance(this).SetToolBar(this, toolbar);
    }

    public void initLayout() {
        //设置菜单内容之外其他区域的背景色
        mainDrawerLayout.setScrimColor(Color.TRANSPARENT);
        navView.setNavigationItemSelectedListener(this);
        navigation.setOnNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mainDrawerLayout, toolbar, R.string.app_name, R.string.title_home);
        mainDrawerLayout.addDrawerListener(toggle);
    }

    /**
     * 初始化toolbar颜色
     * @param position
     */
    private void initStatesColor(int position) {
        switch (position) {
            case 0:
                toolbar.setBackgroundResource(R.color.colorMainGreen);
                break;
            case 1:
                toolbar.setBackgroundResource(R.color.colorMainBlue);
                break;
            case 2:
                toolbar.setBackgroundResource(R.color.colorMainOriange);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mainDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.navigation_home:
                initStatesColor(0);
                pageMainViewpager.setCurrentItem(0);
                break;
            case R.id.navigation_dashboard:
                initStatesColor(1);
                pageMainViewpager.setCurrentItem(1);
                break;
            case R.id.navigation_notifications:
                initStatesColor(2);
                pageMainViewpager.setCurrentItem(2);
                break;
            case R.id.nav_camera:
//        mainDrawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_gallery:
//        mainDrawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_slideshow:
//        mainDrawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_manage:
//        mainDrawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_share:
//        mainDrawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_send:
//        mainDrawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}
