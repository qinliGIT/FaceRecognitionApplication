package com.face.app.facerecognitionapplication.view.pageFirst.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.face.app.facerecognitionapplication.R;
import com.face.app.facerecognitionapplication.service.p.FaceResultDataPresenter;
import com.face.app.facerecognitionapplication.service.v.FaceResultDataView;

import butterknife.ButterKnife;

/**
* Name: FragmentAge
* Author: Leo
* Comment: //TODO
* Date: 2018/7/5 10:30
*/
public class FragmentAge extends Fragment{
    private FaceResultDataPresenter presenter;

    public FragmentAge() {
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pagefirst_layout, null);
        ButterKnife.inject(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new FaceResultDataPresenter(getActivity());
        presenter.onCreate();
        presenter.attachView(mDataView);
        presenter.getSearchDatas("shehui");
    }

    private FaceResultDataView mDataView = new FaceResultDataView() {
        @Override
        public void onSuccess(Object mData) {
            Toast.makeText(getActivity(),mData.toString(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(String result) {
            Toast.makeText(getActivity(),result,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onStop();
    }
}
