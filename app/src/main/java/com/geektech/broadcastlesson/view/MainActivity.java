package com.geektech.broadcastlesson.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.geektech.broadcastlesson.R;
import com.geektech.broadcastlesson.broadcast.AppIntentFilters;
import com.geektech.broadcastlesson.broadcast.BroadcastUtil;
import com.geektech.broadcastlesson.broadcast.IntentConstants;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("ololo", intent.getStringExtra(IntentConstants.MESSAGE_FIELD));
        }
    };

    BroadcastReceiver mTickReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("ololo", "Time tick");
        }
    };

    //region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceivers();

        BroadcastUtil.sendMessage(
                this,
                "Hello receiver",
                AppIntentFilters.MESSAGE_INTENT_NAME);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceivers();
    }

    //endregion

    //region Private

    private void registerReceivers(){
        //register Receiver to local custom broadcast message
        BroadcastUtil.registerLocalReceiver(
                this,
                mReceiver,
                AppIntentFilters.MESSAGE_INTENT_FILTER);

        //register Receiver to time tick, tick interval = 1min
        registerReceiver(
                mTickReceiver,
                new IntentFilter(Intent.ACTION_TIME_TICK)
        );
    }

    private void unregisterReceivers(){
        BroadcastUtil.unregisterLocalReceiver(this, mReceiver);
        unregisterReceiver(mTickReceiver);
    }

    //endregion
}
