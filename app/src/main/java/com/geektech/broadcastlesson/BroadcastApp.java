package com.geektech.broadcastlesson;

import android.app.Application;
import android.util.Log;

// Created by askar on 10/23/18.
public class BroadcastApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("ololo", "Application create");
    }

}
