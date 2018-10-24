package com.geektech.broadcastlesson.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Created by askar on 10/23/18.
public class AirplaneChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            Log.d("ololo", "Airplane mode changed - "
                    + intent.getBooleanExtra("state", false));
        }
    }
}
