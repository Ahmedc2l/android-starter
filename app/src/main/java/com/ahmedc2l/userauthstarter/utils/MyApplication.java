package com.ahmedc2l.userauthstarter.utils;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static synchronized MyApplication getInstance() {
        return instance;
    }
}
