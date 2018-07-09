package com.face.app.facerecognitionapplication.view.pageFirst.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.face.app.facerecognitionapplication.R;
import com.face.app.facerecognitionapplication.view.base.BaseFragment;

import butterknife.ButterKnife;

/**
* Name: FragmentAge
* Author: Leo
* Comment: //TODO
* Date: 2018/7/5 10:30
*/
public class FragmentBeauty extends BaseFragment {
    public FragmentBeauty() {
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pagesecond_layout, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
