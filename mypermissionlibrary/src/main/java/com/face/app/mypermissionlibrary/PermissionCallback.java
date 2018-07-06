package com.face.app.mypermissionlibrary;

import java.io.Serializable;

/**
 * Name: PermissionCallback
 * Author: Leo
 * Comment: //TODO
 * Date: 2018/7/6 13:24
 */
public interface PermissionCallback extends Serializable {
    void onClose();

    void onFinish();

    void onDeny(String permission, int position);

    void onGuarantee(String permission, int position);
}