package com.face.app.facerecognitionapplication.view.base;

import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Name: BaseFragment
 * Author: Leo
 * Comment: //TODO
 * Date: 2018/7/9 13:37
 */

public class BaseFragment extends Fragment {

    //通用性方法
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
