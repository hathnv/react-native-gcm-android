package com.oney.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.react.HeadlessJsTaskService;

public class GcmBroadcastReceiver extends BroadcastReceiver {
    private final static String TAG = GcmModule.class.getCanonicalName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");

        Bundle bundle = intent.getBundleExtra("bundle");

        Intent newIntent = new Intent(context, BgService.class);
        newIntent.putExtra("data", bundle);
        context.startService(newIntent);
        HeadlessJsTaskService.acquireWakeLockNow(context);
//        abortBroadcast();
    }
}