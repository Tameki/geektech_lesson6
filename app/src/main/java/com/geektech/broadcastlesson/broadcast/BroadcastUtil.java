package com.geektech.broadcastlesson.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

// Created by askar on 10/23/18.
public class BroadcastUtil {

    private static LocalBroadcastManager getManager(Context context){
        return LocalBroadcastManager.getInstance(context);
    }

    public static void registerLocalReceiver(
            Context context,
            BroadcastReceiver receiver,
            IntentFilter filter
    ){
        getManager(context).registerReceiver(receiver, filter);
    }

    public static void unregisterLocalReceiver(
            Context context,
            BroadcastReceiver receiver
    ){
        getManager(context).unregisterReceiver(receiver);
    }

    public static void sendMessage(
            Context context,
            String message,
            String intentFilter
    ){
        Intent intent = new Intent(intentFilter);

        intent.putExtra(IntentConstants.MESSAGE_FIELD, message);

        getManager(context).sendBroadcast(intent);
    }
}
