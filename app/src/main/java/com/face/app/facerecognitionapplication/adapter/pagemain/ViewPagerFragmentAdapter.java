package com.face.app.facerecognitionapplication.adapter.pagemain;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Name: ViewPagerFragmentAdapter
 * Author: Leo
 * Comment: //TODO 主页适配器
 * Date: 2018/7/5 10:23
 */
public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {
    private FragmentManager fm;
    private List<? extends Fragment> fragmentList;

    public ViewPagerFragmentAdapter(FragmentManager fm, List<? extends Fragment> fragmentList) {
        super(fm);
        this.fm = fm;
        this.fragmentList = fragmentList;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
