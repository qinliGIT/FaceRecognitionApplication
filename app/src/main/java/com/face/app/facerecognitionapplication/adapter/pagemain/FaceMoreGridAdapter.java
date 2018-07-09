package com.face.app.facerecognitionapplication.adapter.pagemain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.face.app.facerecognitionapplication.R;
import com.face.app.facerecognitionapplication.model.fragment.ColumnItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Name: FaceMoreGridAdapter
 * Author: Leo
 * Comment: //TODO
 * Date: 2018/7/9 11:43
 */

public class FaceMoreGridAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context c;
    private List<ColumnItem> column = new ArrayList<>();

    public FaceMoreGridAdapter(Context c, List<ColumnItem> column) {
        this.c = c;
        this.column = column;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return column.size();
    }

    @Override
    public Object getItem(int i) {
        return column.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_face_more_grid_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ColumnItem item = column.get(i);
        viewHolder.faceMoreGridTv.setText(item.getTextStr());
        Glide.with(c).load(item.getResId()).into(viewHolder.faceMoreGridImg);
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.face_more_grid_img)
        ImageView faceMoreGridImg;
        @Bind(R.id.face_more_grid_tv)
        TextView faceMoreGridTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
