package com.geektech.broadcastlesson.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.geektech.broadcastlesson.view.MainActivity;

// Created by askar on 10/23/18.
// Срабатывает через определенное время после включения телефона
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("ololo", "Receive boot action");

        /**
         * Так делать не стоит)) Только поиграться
         * */

        Intent activityIntent = new Intent(context, MainActivity.class);
        context.startActivity(activityIntent);
    }
}
