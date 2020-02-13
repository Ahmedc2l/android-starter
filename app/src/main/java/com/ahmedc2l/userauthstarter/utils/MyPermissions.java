package com.ahmedc2l.userauthstarter.utils;


import android.content.Context;

import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.PermissionChecker.checkSelfPermission;

/**
 * <h1>MyPermissions</h1>
 * <p>This class handles different permissions requesting and checking.</p>
 *
 * @author Ahmed Fathy
 * @since 2019-06-19
 * @version 1.0
 * */
public class MyPermissions {

    /**
     * <h3>isPermissionGranted</h3>
     * <p>checks whether a specific permission is granted or not</p>
     *
     * @param context the context your calling this function from
     * @param permission the string permission you wanna check
     * @return boolean true if the permission is granted
     * */
    public static boolean isPermissionGranted(Context context, String permission){
        return checkSelfPermission(context, permission) == PermissionChecker.PERMISSION_GRANTED;
    }

    /**
     * <h3>isPermissionsGranted</h3>
     * <p>checks whether an array permissions are granted or not</p>
     *
     * @param context the context your calling this function from
     * @param permissions the array string permissions you wanna check
     * @return boolean true if all the permissions are granted
     * */
    public static boolean isPermissionsGranted(Context context, String[] permissions) {
        for (String permission : permissions) {
            if (!isPermissionGranted(context, permission))
                return false;
        }
        return true;
    }

    /**
     * <h3>requestPermissionsFragment</h3>
     * <p>requests more than one permission</p>
     *
     * @param fragment the fragment you're requesting permissions from
     * @param permissions the string array permissions you wanna request
     * */
    public static void requestPermissionsFragment(Fragment fragment, String[] permissions, int PERMISSION_REQUEST_CODE){
        List<String> notGrantedPermissions = new ArrayList<>();

        // remove the already granted permissions
        for (String permission : permissions) {
            if (!isPermissionGranted(fragment.getContext(), permission))
                notGrantedPermissions.add(permission);
        }

        // no need to request permissions if all requests are already granted
        if(notGrantedPermissions.size() > 0)
            fragment.requestPermissions(notGrantedPermissions.toArray(new String[0]), PERMISSION_REQUEST_CODE);
    }
}
