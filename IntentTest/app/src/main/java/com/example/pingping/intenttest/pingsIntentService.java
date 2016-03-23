package com.example.pingping.intenttest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class pingsIntentService extends IntentService{

    private static final String TAG = "pingping.intenttest";
    public static final String NOTIFICATION = "com.example.pingping.intenttest";
    public static final String RESULT = "result";

    public pingsIntentService() {
        super("pingsIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // This is what the service does
        Log.i(TAG,"The service has now started");
        // communicate with main activity
        int result = 100;
        sendResultsBack(result);
    }

    private void sendResultsBack(int result) {
        Intent i = new Intent(NOTIFICATION);
        i.putExtra(RESULT, result);
        sendBroadcast(i);
        Log.i(TAG, "send back result.");
    }
}
