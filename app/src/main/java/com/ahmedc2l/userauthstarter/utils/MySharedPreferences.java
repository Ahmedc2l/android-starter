package com.ahmedc2l.userauthstarter.utils;

import android.content.SharedPreferences;

/**
 * <h1>UserSettings</h1>
 * <p>This class manages user's different preferences</p>
 *
 * @author Ahmed Fathy
 * @version 1.0
 * @since 11-04-2019
 * */
public class MySharedPreferences {

    /**
     * <h3>saveStringValue</h3>
     * <p>puts String value into SharedPreferences</p>
     *
     * @param key unique key
     * @param value the String value to be saved
     * */
    public static void saveStringValue(String key, String value){
        SharedPreferences sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance().getApplicationContext());
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * <h3>getStringValue</h3>
     * <p>gets String value from SharedPreferences</p>
     *
     * @param key unique key
     * @param defaultValue the String default value
     * */
    public static String getStringValue(String key, String defaultValue){
        SharedPreferences sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance().getApplicationContext());
        return sharedPref.getString(key, defaultValue);
    }

    /**
     * <h3>saveLongValue</h3>
     * <p>puts long value into SharedPreferences</p>
     *
     * @param key unique key
     * @param value the long value to be saved
     * */
    public static void saveLongValue(String key, long value){
        SharedPreferences sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance().getApplicationContext());
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * <h3>getStringValue</h3>
     * <p>gets long value from SharedPreferences</p>
     *
     * @param key unique key
     * @param defaultValue the long default value
     * */
    public static long getLongValue(String key, long defaultValue){
        SharedPreferences sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance().getApplicationContext());
        return sharedPref.getLong(key, defaultValue);
    }

    /**
     * <h3>saveIntegerValue</h3>
     * <p>puts integer value into SharedPreferences</p>
     *
     * @param key unique key
     * @param value the Integer value to be saved
     * */
    public static void saveIntegerValue(String key, int value){
        SharedPreferences sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance().getApplicationContext());
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * <h3>getIntegerValue</h3>
     * <p>gets integer value from SharedPreferences</p>
     *
     * @param key unique key
     * @param defaultValue the Integer default value
     * */
    public static int getIntegerValue(String key, int defaultValue){
        SharedPreferences sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance().getApplicationContext());
        return sharedPref.getInt(key, defaultValue);
    }

    /**
     * <h3>saveBooleanValue</h3>
     * <p>puts boolean value into SharedPreferences</p>
     *
     * @param key unique key
     * @param value the boolean value to be saved
     * */
    public static void saveBooleanValue(String key, boolean value){
        SharedPreferences sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance().getApplicationContext());
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * <h3>getIntegerValue</h3>
     * <p>gets boolean value from SharedPreferences</p>
     *
     * @param key unique key
     * @param defaultValue the boolean default value
     * */
    public static boolean getBooleanValue(String key, boolean defaultValue){
        SharedPreferences sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance().getApplicationContext());
        return sharedPref.getBoolean(key, defaultValue);
    }

    /**
     * <h3>saveFloatValue</h3>
     * <p>puts float value into SharedPreferences</p>
     *
     * @param key unique key
     * @param value the float value to be saved
     * */
    public static void saveFloatValue(String key, float value){
        SharedPreferences sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance().getApplicationContext());
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * <h3>getFloatValue</h3>
     * <p>gets float value from SharedPreferences</p>
     *
     * @param key unique key
     * @param defaultValue the boolean default value
     * */
    public static float getFloatValue(String key, float defaultValue){
        SharedPreferences sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance().getApplicationContext());
        return sharedPref.getFloat(key, defaultValue);
    }

    /**
     * <h3>clear</h3>
     * <p>clears all the saved values in the shared preferences</p>
     *
     * */
    public static void clear(){
        SharedPreferences sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance().getApplicationContext());
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear().apply();
    }
}
