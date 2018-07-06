package com.face.app.facerecognitionapplication.view.pageFirst.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.face.app.facerecognitionapplication.R;
import com.face.app.facerecognitionapplication.service.p.FaceResultDataPresenter;
import com.face.app.facerecognitionapplication.service.v.FaceResultDataView;
import com.face.app.mypermissionlibrary.PermissionCallback;
import com.face.app.mypermissionlibrary.PermissionU;

import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Name: FragmentAge
 * Author: Leo
 * Comment: //TODO
 * Date: 2018/7/5 10:30
 */
public class FragmentAge extends Fragment {
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

//        PermissionU.create(getActivity())
//                .checkMutiPermission(new PermissionCallback() {
//                    @Override
//                    public void onClose() {
//                        Log.i(TAG, "onClose");
//                        showToast("用户关闭权限申请");
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        showToast("所有权限申请完成");
//                    }
//
//                    @Override
//                    public void onDeny(String permisson, int position) {
//                        Log.i(TAG, "onDeny");
//                    }
//
//                    @Override
//                    public void onGuarantee(String permisson, int position) {
//                        Log.i(TAG, "onGuarantee");
//                    }
//                });
    }

    private void showToast(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }

    private FaceResultDataView mDataView = new FaceResultDataView() {
        @Override
        public void onSuccess(Object mData) {
//            Toast.makeText(getActivity(), mData.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(String result) {
//            Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onStop();
    }
}
