package com.geektech.broadcastlesson.broadcast;

import android.content.IntentFilter;

// Created by askar on 10/23/18.
public class AppIntentFilters {
    public static String MESSAGE_INTENT_NAME = "com.geektech.broadcastlesson.message";
    public static IntentFilter MESSAGE_INTENT_FILTER =
            new IntentFilter(MESSAGE_INTENT_NAME);
}
