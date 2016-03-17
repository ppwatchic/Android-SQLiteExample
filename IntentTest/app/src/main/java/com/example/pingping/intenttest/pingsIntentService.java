package com.example.pingping.intenttest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class pingsIntentService extends IntentService{

    private static final String TAG = "pingping.intenttest";

    public pingsIntentService() {
        super("pingsIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // This is what the service does
        Log.i(TAG,"The service has now started");
    }
}
