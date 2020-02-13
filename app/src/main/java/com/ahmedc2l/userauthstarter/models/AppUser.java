package com.ahmedc2l.userauthstarter.models;

import com.ahmedc2l.userauthstarter.utils.MySharedPreferences;

/**
 * <h1>AppUser</h1>
 * <p>This class defines user's different properties</p>
 *
 * @author Ahmed Fathy
 * @version 1.0
 * @since 11-Apr-2019
 * */
public class AppUser {

    // Has the user opened the app before?
    public static boolean isFirstOpen(){
        return MySharedPreferences.getBooleanValue("_first_open", true);
    }
    public static void setFirstOpen(boolean value){
        MySharedPreferences.saveBooleanValue("_first_open", value);
    }

    // User's bearer token used in different api callbacks
    public static String getToken() {
        return MySharedPreferences.getStringValue("_token", null);
    }
    public static void setToken(String token) {
        MySharedPreferences.saveStringValue("_token", token);
    }
}
