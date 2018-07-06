package com.face.app.mypermissionlibrary;

import java.io.Serializable;

/**
 * Name: PermissionItem
 * Author: Leo
 * Comment: //TODO
 * Date: 2018/7/6 13:25
 */
public class PermissionItem implements Serializable {
    public String PermissionName;
    public String Permission;
    public int PermissionIconRes;

    public PermissionItem(String permission, String permissionName, int permissionIconRes) {
        Permission = permission;
        PermissionName = permissionName;
        PermissionIconRes = permissionIconRes;
    }

    public PermissionItem(String permission) {
        Permission = permission;
    }
}
