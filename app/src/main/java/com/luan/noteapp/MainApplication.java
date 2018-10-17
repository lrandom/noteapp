package com.luan.noteapp;

import android.app.Application;

import com.luan.noteapp.models.MyObjectBox;

import io.objectbox.BoxStore;

public class MainApplication extends Application {
    private BoxStore mBoxStore;
    private static MainApplication sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp=MainApplication.this;
        mBoxStore = MyObjectBox.builder().androidContext(MainApplication.this).build();
    }

    public BoxStore getmBoxStore() {
        return mBoxStore;
    }

    public static MainApplication getApp() {
        return sApp;
    }

}
