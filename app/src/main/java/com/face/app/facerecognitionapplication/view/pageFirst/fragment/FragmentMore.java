package com.face.app.facerecognitionapplication.view.pageFirst.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.face.app.facerecognitionapplication.R;
import com.face.app.facerecognitionapplication.adapter.pagemain.FaceMoreGridAdapter;
import com.face.app.facerecognitionapplication.control.ContentProvider;
import com.face.app.facerecognitionapplication.model.fragment.ColumnItem;
import com.face.app.facerecognitionapplication.view.base.BaseFragment;

import java.util.List;

import butterknife.OnItemClick;

/**
 * Name: FragmentAge
 * Author: Leo
 * Comment: //TODO
 * Date: 2018/7/5 10:30
 */
public class FragmentMore extends BaseFragment implements AdapterView.OnItemClickListener {
    GridView faceMoreGrid;

    private FaceMoreGridAdapter adapter;

    public FragmentMore() {
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pagethird_layout, null);
        findId(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void findId(View view) {
        faceMoreGrid = view.findViewById(R.id.faceMoreGrid);
    }

    private void init() {
        adapter = new FaceMoreGridAdapter(getActivity(), loadColumn());
        faceMoreGrid.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        faceMoreGrid.setOnItemClickListener(this);
    }

    private List<ColumnItem> loadColumn() {
        return ContentProvider.getInstance(getActivity()).getColumnlist();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ColumnItem item = (ColumnItem) adapterView.getItemAtPosition(i);
        Toast.makeText(getActivity(), "You clicked: " + item.getTextStr(), Toast.LENGTH_SHORT).show();
    }
}
